package com.example.todolist.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Member extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // null 값 오류가 안뜨게끔 false
    private String membername;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Todo> comment;
    private List<Todo> content;

//    public Member(String membername, Integer age, String email, String password){
//        this.membername=membername;
//        this.age = age;
//        this.email = email;
//        this.password = password;
//    }

//    public Member(MemberRequestDto requestDto) {
//        this.membername = requestDto.getMembername();
//        this.age = requestDto.getAge();
//        this.email = requestDto.getEmail();
//        this.password = requestDto.getPassword();
//    }

//    //멤버 수정
//    public void update(MemberRequestDto requestDto) {
//        this.membername = requestDto.getMembername();
//        this.age = requestDto.getAge();
//        this.email = requestDto.getEmail();
//        this.password = requestDto.getPassword();
//    }

    //멤버 삭제
//    public void delete(MemberRequestDto requestDto) {
//        this.membername = requestDto.getMembername();
//        this.age = requestDto.getAge();
//        this.email = requestDto.getEmail();
//    }
}
