package com.fishpond.repository;

import com.fishpond.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> getDistinctByUserNameAndPassWord(String userName,String password);
    Optional<User> findDistinctByUserName(String userName);
}
