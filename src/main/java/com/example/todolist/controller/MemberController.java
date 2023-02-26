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
//final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성
//새로운 필드를 추가할 때 다시 생성자를 만들어서 관리해야하는 번거로움을 없애준다.

public class MemberController {
    private final MemberRepository memberRepository;

    //사용자 조회
    @GetMapping("/memberlist")
    public String memberList(Model model){
        model.addAttribute("password",new MemberRequestDto()); //Model addAttribute(Object value);
        //Modle을 이용하여 View에 데이터 넘겨주기
        //Model addAttribute(key, value);
        List<Member> memberList= memberRepository.findAll();
        model.addAttribute("memberList",memberList);
        return "memberList";
    }

    @GetMapping("register")
    public String register(Model model){
        model.addAttribute("member" ,new MemberRequestDto());
        return "register";
    }

    //사용자 등록
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

    //비밀번호 확인
    @PostMapping("/passwordCheck")
    public String passCheck(@ModelAttribute MemberRequestDto member){
//        System.out.println(member.getPassword());
//        System.out.println("이름 :"+member.getMembername());
        Optional<Member> member1 = Optional.ofNullable(memberRepository.findByMembername(member.getMembername()));
        String password=member1.get().getPassword();
        String name = member1.get().getMembername();
        if(password.equals(member.getPassword())){
            System.out.println("비빌번호가 일치합니다.");
            return "redirect:/todolist/"+member1.get().getId();
        }else{
            return "비밀번호가 일치하지 않습니다.";
        }
    }

}