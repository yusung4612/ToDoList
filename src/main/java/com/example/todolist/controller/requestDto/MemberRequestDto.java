package com.example.todolist.controller.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MemberRequestDto {

    private Long id;

    private String membername;

    private Integer age;

    @NotBlank(message = "이메일과 비밀번호를 모두 입력해주세요!")

    @Size(min=8,max=30, message= "8자리이상 30자리 미만 글자로 email를 만들어주세요")

    @Pattern(regexp = "^[0-9a-zA-Z]+@[a-zA-Z]+\\.[a-zA-Z]+$" , message = "이메일 형식을 확인해 주세요.")

    private String email;

    private String password; //비밀번호
    private String passwordConfirm;
}