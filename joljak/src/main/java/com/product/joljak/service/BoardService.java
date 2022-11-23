package com.product.joljak.service;

import com.product.joljak.entity.Board;
import com.product.joljak.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class  BoardService {

    @Autowired
    private BoardRepository boardRepository;

    // 게시글 리스트 처리
    public Page<Board> boardList(Pageable pageable) {

        return boardRepository.findAll(pageable);
    }

    //  글쓰기
    public void write(Board board) {

        boardRepository.save(board);
    }

    //상세페이지
    public Board boardView(Integer id) {
        return boardRepository.findById(id).get();
    }

}
