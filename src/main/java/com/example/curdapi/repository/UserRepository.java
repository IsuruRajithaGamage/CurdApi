package com.example.curdapi.repository;

import com.example.curdapi.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

     //Users findPasswordByName(String username);
     Users findByUsernameAndPassword(  String name, String  ipassword);
}
