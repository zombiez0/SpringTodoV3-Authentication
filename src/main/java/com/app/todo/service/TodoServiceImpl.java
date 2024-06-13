package com.app.todo.service;

import com.app.todo.models.Todo;
import com.app.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements ITodoService {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/getTodo/{id}")
    public Todo getTodo(long id) {
        Optional<Todo> o = this.todoRepository.findById(id);
        if(o.isPresent()) {
            return o.get();
        }else{
            return null;
        }
    }

    public Todo createTodo(Todo todo) {
        return this.todoRepository.save(todo);
    }


    public boolean deleteTodo(Long id) {
        this.todoRepository.deleteById(id);
        return true;
    }

    public List<Todo> getAllTodos(String userName) {
        return this.todoRepository.findByUserName(userName);
    }
}
