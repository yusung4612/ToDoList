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

    @Column(nullable = false)
    private String membername; //멤버이름

    @Column(nullable = false)
    private Integer age; //나이

    @Column(nullable = false, unique = true)
    private String email; //이메일

    @JsonIgnore
    @Column(nullable = false)
    private String password; //패스워드

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Todo> content;

//    //멤버 수정
//    public void update(MemberRequestDto requestDto) {
//        this.membername = requestDto.getMembername();
//        this.age = requestDto.getAge();
//        this.email = requestDto.getEmail();
//        this.password = requestDto.getPassword();
//    }
}
