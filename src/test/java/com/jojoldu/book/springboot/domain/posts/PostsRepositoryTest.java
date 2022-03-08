package com.jojoldu.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/* save, findAll 기능 테스트 */

@RunWith(SpringRunner.class)
@SpringBootTest // H2 데이터베이스 자동 실행
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // Junit 단위테스트가 끝날 때마다 수행 (테스트 동시 수행 시 데이터 남아있는 오류 방지)
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {

        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() // 테이블 posts에 insert/update 쿼리 실행
                .title(title)
                .content(content)
                .author("jojoldu@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll(); // 테이블 posts에 있는 모든 데이터 조회

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2022, 3, 8, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>> createdDate=" + posts.getCreatedDate()+", modifiedDate=" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now); //createdDate가 현재보다 미래이면 true, 아니면 false 리턴
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
