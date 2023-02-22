package com.example.todolist.controller;

import com.example.todolist.controller.requestDto.SearchRequestDto;
import com.example.todolist.controller.requestDto.TodoRequestDto;
import com.example.todolist.domain.Member;
import com.example.todolist.domain.Todo;
import com.example.todolist.repository.MemberRepository;
import com.example.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final MemberRepository memberRepository;
    private final TodoRepository todoRepository;

    @GetMapping("/todolist/{id}")
    public String todolist(Model model, @PathVariable Long id) {
        Optional<Member> member = memberRepository.findById(id);

        model.addAttribute("member", member);
        model.addAttribute("todo", new TodoRequestDto());
        model.addAttribute("searches",new SearchRequestDto());
        return "todolist";
    }

    @PostMapping("/todolist/{id}")
    public String todoSubmit(@ModelAttribute TodoRequestDto todo, @PathVariable Long id) {
        Todo todo1 = Todo.builder()
                .member(memberRepository.findById(id).get())
                .content(todo.getContent())
                .build();
        todoRepository.save(todo1);
        return "redirect:" + id;
    }

    //할 일 삭제
    @GetMapping ("/todolist/delete")
    public String todoDelete(Long id ,Long member)  {
        System.out.println("삭제 에이피아이 : "+id);
            System.out.println("삭제 돼라");
            todoRepository.deleteById(id);

        return "redirect:"+member;
    }
    //투두 결과 페이지

    //할 일 검색
    @GetMapping("/todosearch")
    public String search(@ModelAttribute SearchRequestDto keyword ,Model model ){
        System.out.println("keyword : " + keyword.getKeyword());

       List<Todo> todoList=todoRepository.search(keyword.getKeyword());
        System.out.println(todoList);
       model.addAttribute("todolist",todoList);
       return "searchResult";
    }

//    @PostMapping("/todosearch")
//    public String search(Model model , String keyword){
//        List<Todo> todoList=todoRepository.search(keyword);
//        model.addAttribute("todosearch",todoList);
//        return "todolist";
//    }
//    @GetMapping("/todolist")
//    public String todoList(Model model, @PageableDefault(page=0, size=10, sort="id",
//                            direction= Sort.Direction.DESC)Pageable pageable,
//                            String searchKeyword) {
//        Page<Todo> list = null;
//        if (searchKeyword == null) {
//            // 검색 단어가 없으면 기존 화면을 보여준다.
////            list =todoService.boardList(pageable);
////            list = todoRepository.todoSearchList(pageable);
//        } else {
//            // 검색 단어가 들어오면 검색 단어에 맞게 나온다. 쿼리스트링으로 들어가는 키워드를 찾아냄
////            list = todoService.boardSearchList(searchKeyword, pageable);
////            list = todoRepository.todoSearchList(searchKeyword, pageable);
//        }
//        //페이지블럭 처리
//        //1을 더해주는 이유는 pageable은 0부터라 1을 처리하려면 1을 더해서 시작해주어야 한다.
//        int nowPage = list.getPageable().getPageNumber() + 1;
//        //-1값이 들어가는 것을 막기 위해서 max값으로 두 개의 값을 넣고 더 큰 값을 넣어주게 된다.
//        int startPage =  Math.max(nowPage - 4, 1);
//        int endPage = Math.min(nowPage+ + 9, list.getTotalPages());
//
//
//        model.addAttribute("list", list);
//        model.addAttribute("nowPage",nowPage);
//        model.addAttribute("startPage", startPage);
//        model.addAttribute("endPage", endPage);
//
//        return "todolist";
//    }

}