package com.example.todolist.service;

import com.example.todolist.domain.Todo;
import com.example.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class TodoService {

    public final TodoRepository todoRepository;

    @Transactional
    public void todoStar(Long id, boolean key){
        Todo todo=todoRepository.findById(id).get();
        if(!key){
            System.out.println("뻘스를 투르로");
            todo.starUpdate(true);
        }else{
            System.out.println("트루를 뻘스로");
            todo.starUpdate(false);
        }
    }
    @Transactional
    public void complete(Long id, boolean key){
        Todo todo=todoRepository.findById(id).get();
        if(!key){
            System.out.println("뻘스를 투르로");
            todo.completeUpdate(true);
        }else{
            System.out.println("트루를 뻘스로");
            todo.completeUpdate(false);
        }
    }
    //할 일 삭제
//    public void deleteById(Long id) {
//        todoRepository.deleteById(id);
//    }
//    public void deleteAll(Long[] deletedId) {
//        todoRepository.deleteTodo(deletedId);
//    }
}
