package com.product.joljak.service;

import com.product.joljak.dto.BoardDto;
import com.product.joljak.entity.Board;
import com.product.joljak.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class  BoardService {

    @Autowired
    private BoardRepository boardRepository;

    // 게시글 리스트 처리
    public Page<Board> boardList(Pageable pageable) {

        return boardRepository.findAll(pageable);
    }

    //  글쓰기
    public Long write(BoardDto boardDto) {

        return boardRepository.save(boardDto.toEntity()).getId();
    }

    //상세페이지
    public Board boardView(Long id) {
        return boardRepository.findById(id).get();
    }


}
