package com.pracProject.springboot.web;

import com.pracProject.springboot.service.posts.PostsService;
import com.pracProject.springboot.web.dto.PostsResponseDto;
import com.pracProject.springboot.web.dto.PostsSaveRequestDto;
import com.pracProject.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController

public class PostApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public long sava(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public  Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
