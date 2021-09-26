package com.pracProject.springboot.web;

import com.pracProject.springboot.service.posts.PostsService;
import com.pracProject.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController

public class PostApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public long sava(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
}
