package com.example.todolist.repository;

import com.example.todolist.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {


    // 할 일 검색
    @Query(value = "SELECT p FROM Todo p WHERE p.content LIKE %:keyword%")
    List<Todo> search(@Param("keyword") String keyword);
}