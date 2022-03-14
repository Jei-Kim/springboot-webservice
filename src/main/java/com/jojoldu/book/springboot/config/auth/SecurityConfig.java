package com.jojoldu.book.springboot.config.auth;

import lombok.RequiredArgsConstructor;

import com.jojoldu.book.springboot.domain.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // 스프링 시큐리티 설정들을 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers().frameOptions().disable() // h2-console을 사용하기 위해 해당 옵션 비활성화
                .and()
                .authorizeRequests() // url별 권한 관리 설정
                .antMatchers("/", "/css/**", "/images/**",
                        "/js/**", "/h2-console/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // antMatchers: 권한 관리 대상을 지정(전체/권한별 열람권한)
                .anyRequest().authenticated() // 설정된 값 외의 url들은
                .and()
                .logout() //로그아웃 시 기능 설정 진입점
                .logoutSuccessUrl("/")  // 홈으로 이동
                .and()
                .oauth2Login()// OAuth2 로그인 기능 설정 진입점
                .userInfoEndpoint() // 로그인 성공 이후 사용자 정보를 가져올 때 설정 담당
                .userService(customOAuth2UserService); //소셜로그인 성공 시 후속조치할 UserService 인테페이스의 구현체를 등록
    }
}
