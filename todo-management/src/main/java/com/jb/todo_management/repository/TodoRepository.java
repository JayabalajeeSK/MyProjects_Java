package com.jb.todo_management.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jb.todo_management.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{

}//