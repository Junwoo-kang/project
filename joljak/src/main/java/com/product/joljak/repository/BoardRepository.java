package com.product.joljak.repository;

import com.product.joljak.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board,Integer>{

}
