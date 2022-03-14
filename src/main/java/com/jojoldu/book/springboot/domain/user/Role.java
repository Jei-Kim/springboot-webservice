package com.jojoldu.book.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
/* 스프링시큐리티에서는 권한코드에 항상 ROLE_이 있어야 함
    - 코드별 키 값을 아래와 같이 ROLE_XXX로 지정
 */
@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;

}
