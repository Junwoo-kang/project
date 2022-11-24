package com.product.joljak.entity;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
//    private String type;
    private String content;
//    private String nickname;
    private String regdate;
//    private Date updatedate;
    private Long views;
//    private Integer referrals;

//    public Board() {
//    }
//
//    public Board(int b_num, String type, String content, String nickname, Date regdate, Date updatedate, int views, int referrals) {
//        this.b_num = b_num;
//        this.type = type;
//        this.content = content;
//        this.nickname = nickname;
//        this.regdate = regdate;
//        this.updatedate = updatedate;
//        this.views = views;
//        this.referrals = referrals;
//    }
}
