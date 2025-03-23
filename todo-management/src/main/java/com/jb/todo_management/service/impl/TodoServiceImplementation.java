package com.jb.todo_management.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jb.todo_management.dto.TodoDto;
import com.jb.todo_management.entity.Todo;
import com.jb.todo_management.repository.TodoRepository;
import com.jb.todo_management.service.TodoService;
@Service
public class TodoServiceImplementation implements TodoService{

    private TodoRepository todoRepository;
    private ModelMapper modelMapper;
    @Autowired
    public TodoServiceImplementation(TodoRepository todoRepository, ModelMapper modelMapper) {
        this.todoRepository = todoRepository;
        this.modelMapper = modelMapper;
    }



    @Override
    public TodoDto addTodo(TodoDto todoDto) 
    {
        // Todo todo = new Todo();
        // todo.setTitle(todoDto.getTitle());
        // todo.setDescription(todoDto.getDescription());
        // todo.setCompleted(todoDto.isCompleted());
        Todo todo = modelMapper.map(todoDto, Todo.class);
        Todo savedTodo = todoRepository.save(todo);

        // TodoDto savedTodoDto = new TodoDto();
        // savedTodoDto.setId(savedTodo.getId());
        // savedTodoDto.setTitle(savedTodo.getTitle());
        // savedTodoDto.setDescription(savedTodo.getDescription());
        // savedTodoDto.setCompleted(savedTodo.isCompleted());
        TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);
        return savedTodoDto;
    }
}