package com.fishpond.sercurityUtils;


import com.fishpond.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    String token;
    User user;
}
