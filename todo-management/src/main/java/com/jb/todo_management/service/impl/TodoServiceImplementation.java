package com.jb.todo_management.service.impl;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jb.todo_management.dto.TodoDto;
import com.jb.todo_management.entity.Todo;
import com.jb.todo_management.exception.ResourceNotFoundException;
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
        Todo todo = modelMapper.map(todoDto, Todo.class);
        Todo savedTodo = todoRepository.save(todo);

        TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);
        return savedTodoDto;
    }

    @Override
    public TodoDto getTodo(Long id) 
    {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: "+id));
        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public List<TodoDto> getAllTodos() 
    {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDto.class))
                                                       .collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long id) 
    {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: "+id));

        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());
        Todo updatedTodo = todoRepository.save(todo);
        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public void deleteTodo(Long id) 
    {
       todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with ID: "+ id));
        todoRepository.deleteById(id);
    }

    @Override
    public TodoDto completeTodo(Long id) 
    {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with ID: "+ id));
        todo.setCompleted(Boolean.TRUE);
        Todo updatedTodo = todoRepository.save(todo);
        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public TodoDto inCompleteTodo(Long id) 
    {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with ID: "+ id));
        todo.setCompleted(Boolean.FALSE);
        Todo updatedTodo = todoRepository.save(todo);
        return modelMapper.map(updatedTodo, TodoDto.class);
    }
}