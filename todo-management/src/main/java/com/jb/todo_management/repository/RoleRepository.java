package com.jb.todo_management.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jb.todo_management.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

    Role findByName(String name);
}//