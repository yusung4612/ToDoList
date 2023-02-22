package com.example.todolist.service;

import com.example.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    public final TodoRepository todoRepository;

    //할 일 삭제
//    public void deleteById(Long id) {
//        todoRepository.deleteById(id);
//    }
//    public void deleteAll(Long[] deletedId) {
//        todoRepository.deleteTodo(deletedId);
//    }
}
