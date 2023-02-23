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
    private String content;

    @Column(name="is_completed")
    private boolean isCompleted;

    @Column(name="starred")
    private boolean starred;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    public void starUpdate(boolean key){
        this.starred=key;
    }
    public void completeUpdate(boolean key){
        this.isCompleted=key;
    }

}