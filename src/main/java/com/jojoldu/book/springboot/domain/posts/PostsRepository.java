package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/* Posts 클래스로 DB를 접근하게 해주는 JpaRepository
* - MyBtis의 Dao라 불리는 DB Layer 접근자
* - JpaRepository<Entity 클래스, PK 타입> 상속받으면 CRUD 메소드 자동 생성 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

}