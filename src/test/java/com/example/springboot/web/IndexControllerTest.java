package com.example.springboot.web;

import org.assertj.core.api.Assertions;
import org.example.springboot.Application;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = Application.class)
public class IndexControllerTest {

    @Autowired private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지_로딩() {

        // when
        String body = this.restTemplate.getForObject("/", String.class);

        // then
        Assertions.assertThat(body).contains("스프링 부트로 시작하는 웹서비스");
    }

}
