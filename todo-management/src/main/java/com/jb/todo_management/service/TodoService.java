package com.jb.todo_management.service;

import com.jb.todo_management.dto.TodoDto;

public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodo(Long id);

}