package com.product.joljak.entity;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor(access=AccessLevel.PROTECTED)
public class Board extends TimeEntity{
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100,nullable = false)
    private String title;
//    private String type;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

//    @Column(length = 10,nullable = false)
    private String nickname;

    @Column(nullable = true)
    private Long views;

    @Builder
    public Board(Long id, String title, String content, String nickname) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.nickname = nickname;
    }

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
