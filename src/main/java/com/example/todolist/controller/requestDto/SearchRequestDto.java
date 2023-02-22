package com.example.todolist.controller.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SearchRequestDto {
    private Long id;
    private String keyword;
}
