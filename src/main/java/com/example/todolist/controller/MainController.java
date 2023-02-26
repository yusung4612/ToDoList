package com.example.todolist.controller;

import com.example.todolist.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequiredArgsConstructor // 왜사용?
public class MainController {

//    private final MemberRepository memberRepository;

    @GetMapping("/")
    public String main(Model model){
        return "index";
    }


}