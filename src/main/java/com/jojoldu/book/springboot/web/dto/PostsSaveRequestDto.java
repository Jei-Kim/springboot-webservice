package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/* Entity 클래스는 DB와 직접 맞닿은 핵심 클래스이기 때문에 Request/Response 클래스로 사용하지 않음
- DB Layer와 ViewLayer의 분리를 위해 Dto 클래스를 따로 생성함
- Dto는 컨트롤러에서 사용함
 */
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto (String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
