package com.example.todolist.service;

import com.example.todolist.controller.requestDto.TodoRequestDto;
import com.example.todolist.domain.Todo;
import com.example.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class TodoService {

    public final TodoRepository todoRepository;

    //할 일 중요여부
    @Transactional
    public void todoStar(Long id, boolean key){
        Todo todo=todoRepository.findById(id).get();
        if(!key){
            System.out.println("false를 true로");
            todo.starUpdate(true);
        }else{
            System.out.println("true를 false로");
            todo.starUpdate(false);
        }
    }

    //할 일 완료여부
    @Transactional
    public void complete(Long id, boolean key){
        Todo todo=todoRepository.findById(id).get();
        if(!key){
            System.out.println("false를 true로");
            todo.completeUpdate(true);
        }else{
            System.out.println("true를 false로");
            todo.completeUpdate(false);
        }
    }
    //할 일 수정
    @Transactional
    public Long update(TodoRequestDto todo, Long id){
        Todo todoUpdate =todoRepository.findById(id).orElse(null);

        todoUpdate.update(todo.getContent());
        return todoUpdate.getMember().getId();
    }
}
