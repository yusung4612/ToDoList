package com.example.todolist.controller;

import com.example.todolist.controller.requestDto.MemberRequestDto;
import com.example.todolist.domain.Member;
import com.example.todolist.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;
    @GetMapping("/memberlist")
    public String memberList(Model model){
        model.addAttribute("password",new MemberRequestDto());
        List<Member> memberList= memberRepository.findAll();
        model.addAttribute("memberList",memberList);
        return "memberList";
    }

    @GetMapping("register")
    public String register(Model model){
        model.addAttribute("member" ,new MemberRequestDto());
        return "register";
    }

    @PostMapping("register")
    public String registerSubmit(@ModelAttribute MemberRequestDto member){
        System.out.println(member.getAge());
        Member members= Member.builder()
                .age(member.getAge())
                .membername(member.getMembername())
                .password(member.getPassword())
                .email(member.getEmail())
                .build();
        memberRepository.save(members);
        return "redirect:/";
    }
    @PostMapping("/passwordCheck")
    public String passCheck(@ModelAttribute MemberRequestDto member){
        System.out.println(member.getPassword());
        System.out.println("이름 :"+member.getMembername());
        Optional<Member> member1 = Optional.ofNullable(memberRepository.findByMembername(member.getMembername()));
        String password=member1.get().getPassword();
        String name = member1.get().getMembername();
        if(password.equals(member.getPassword())){
            System.out.println("비빌번호가 맞았어");
            return "redirect:/todolist/"+member1.get().getId();
        }else{
            return "비밀번호가 틀렸습니다.";
        }
    }

}