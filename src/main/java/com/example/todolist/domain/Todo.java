package com.example.todolist.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="content",nullable = false)
    private String content; //할 일 내용

    @Column(name="is_completed")
    private boolean isCompleted; //완료여부 true or false

    @Column(name="starred")
    private boolean starred; // 중요여부 true of false

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    public void update(String content) {
        this.content=content;
    }
    public void starUpdate(boolean key){
        this.starred=key;
    }
    public void completeUpdate(boolean key){
        this.isCompleted=key;
    }
}