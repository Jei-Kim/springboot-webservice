package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // 스프링부트 테스트와 JUnit 연결
@WebMvcTest(controllers = HelloController.class) // web(spring mvc)에 집중
public class HelloControllerTest {

    @Autowired // 스프링 빈 주입
    private MockMvc mvc; // 웹 API 테스트 시 사용 - HTTP method에 대한 API 테스트 가능

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")). // MockMvc를 통해 /hello 주소로 HTTP GET 요청
                andExpect(status().isOk()). // mvc.perform의 결과를 검증 - HTTP Header의 Status 검증
                andExpect(content().string(hello)); //mvc.perform의 결과를 검증 - 응답 본문의 내용 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                        get("/hello/dto")
                                .param("name", name)
                                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}
