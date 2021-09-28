package com.pracProject.springboot.web;

import com.pracProject.springboot.domain.posts.Posts;
import com.pracProject.springboot.domain.posts.PostsRepository;
import com.pracProject.springboot.web.dto.PostsSaveRequestDto;
import com.pracProject.springboot.web.dto.PostsUpdateRequestDto;
import javafx.geometry.Pos;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지로딩(){
        //WHen
        String body = this.restTemplate.getForObject("/" , String.class);

        //then
        assertThat(body).contains("글 등록");
    }
}
