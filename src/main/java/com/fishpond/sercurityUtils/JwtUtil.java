package com.fishpond.sercurityUtils;

import com.fishpond.model.User;
import io.jsonwebtoken.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


import java.util.Date;

@Component
@Log4j2
public class JwtUtil {

    private final String jwtSecret = "tuky";

    private int jwtExpirationMs = 86400000;

    public String generateJwtToken(Authentication authentication){
        User userPrincipal = (User) authentication.getPrincipal();


        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512,jwtSecret)
                .compact();
    }

    public String getUserNameFormJwtToken(String token){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken){
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return  true;
        }
        catch (SignatureException e){
            log.debug("invalid jwt signature: {}",e.getMessage());
        }
        catch (MalformedJwtException e){
            log.debug("invalid jwt token: {}",e.getMessage());
        }
        catch (ExpiredJwtException e){
            log.debug("jwt token is expired: {}",e.getMessage());
        }
        catch (IllegalArgumentException e){
            log.debug("jwt claims string is empty: {}",e.getMessage());
        }
        return false;
    }
}