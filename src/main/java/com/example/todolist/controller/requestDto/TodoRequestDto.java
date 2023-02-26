package com.example.todolist.controller.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TodoRequestDto {
    private Long id;
    private Long memberId;
    private String content; //할 일 내용

}