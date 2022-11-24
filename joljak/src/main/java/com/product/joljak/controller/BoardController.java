package com.product.joljak.controller;

import com.product.joljak.entity.Board;
import com.product.joljak.service.BoardService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@NoArgsConstructor
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/board")
    public String board(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<Board> list = boardService.boardList(pageable);
//        Page<Board> list = boardService.boardList(pageable);
        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 2, 1);
        int endPage = Math.min(nowPage + 2, list.getTotalPages());

//        model.addAttribute("boardList", boardService.boardList(pageable));
        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "board/board";
    }

    @GetMapping("/boardwrite")
    public String boardwrite() {
        return "board/board_write";
    }

    @PostMapping("/boardwritepro")
    public String boardWritePro(Board board) {
        boardService.write(board);
        return "redirect:board";
    }

    @GetMapping("/board/view")
    public String boardView(Model model, Integer id) {
        model.addAttribute("board", boardService.boardView(id));
        return "board/boardview";
    }

//    @GetMapping("/board/views/{id}")
//    public String view(@PageableDefault("id") Long id, Model model) {
//        model.addAttribute("board", boardService.boardView(id));
//        Long countVisit = model.getCount
//    }

    @GetMapping("/login/login")
    public String login() {

        return "login/login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }


}
