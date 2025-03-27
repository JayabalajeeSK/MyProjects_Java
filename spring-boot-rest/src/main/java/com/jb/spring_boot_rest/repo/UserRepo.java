package com.jb.spring_boot_rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jb.spring_boot_rest.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
    User findByUsername(String username);
}