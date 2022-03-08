package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/* 실제 테이블과 매칭될 클래스 - Entity 클래스 */

@Getter
@NoArgsConstructor // 기본 생성자 자동 추가 == public Post() {}
@Entity // 테이블과 링크될 클래스임을 명시 (카멜케이스 이름을 언더스코어 네이밍(_)으로 매칭)
public class Posts extends BaseTimeEntity {

    @Id // 해당 테이블의 PK 키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 칼럼, 생략 가능하나 기본값과 다르게 변경 시 이와 같이 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // 상동
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
