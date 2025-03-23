package com.jb.todo_management.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jb.todo_management.dto.TodoDto;
import com.jb.todo_management.service.TodoService;

@RestController
@RequestMapping("api/todos")
public class TodoController 
{
    private TodoService todoService;
    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

//add todo rest api
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto)
    {
        TodoDto savedTodo = todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }
//get todo by id rest api
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId)
    {
        TodoDto todoDto = todoService.getTodo(todoId);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }
//get all todos rest api
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos()
    {
        List<TodoDto> todos = todoService.getAllTodos();
        //return new ResponseEntity<>(todos, HttpStatus.OK);
        return ResponseEntity.ok(todos);
    }
//update todo by id rest api
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable("id") Long todoId)
    {
        TodoDto updatedTodo = todoService.updateTodo(todoDto, todoId);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }
//delete todo by id rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId)
    {
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok(" Todo Deleted Successfully");
    }
//complete (status) todo by id rest api
    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long todoId)
    {
        TodoDto updatedTodo = todoService.completeTodo(todoId);
        return ResponseEntity.ok(updatedTodo);
    }
//in - complete (status) todo by id rest api
    @PatchMapping("{id}/in-complete")
    public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable("id") Long todoId)
    {
        TodoDto updatedTodo = todoService.inCompleteTodo(todoId);
        return ResponseEntity.ok(updatedTodo);
    }
}