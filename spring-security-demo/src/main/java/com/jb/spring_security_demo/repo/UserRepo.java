package com.jb.spring_security_demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jb.spring_security_demo.model.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
    User findByUsername(String username);
}
