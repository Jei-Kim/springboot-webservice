package com.jojoldu.book.springboot.web.web;

import com.jojoldu.book.springboot.web.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON을 반환하는 컨트롤러로 만들어 줌
public class HelloController {

    /*
    @GetMapping // HTTP method인 Get 요청을 받을 수 있는 API 생성
    public String Hello() {
        return "hello";
    }
    */

    /*
    @RequestParam: 외부에서 API로 넘긴 파라미터를 가져옴
    - 외부에서 name이라는 이름으로 넘긴 파라미터(@RequestParam("name"))를
      메소드 파라미터 name(String name)에 저장
     */
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}

