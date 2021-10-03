package com.pracProject.springboot.service.posts;

import com.pracProject.springboot.domain.posts.Posts;
import com.pracProject.springboot.domain.posts.PostsRepository;
import com.pracProject.springboot.web.dto.PostsListResponseDto;
import com.pracProject.springboot.web.dto.PostsResponseDto;
import com.pracProject.springboot.web.dto.PostsSaveRequestDto;
import com.pracProject.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id , PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id ));
        posts.update(requestDto.getTitle(), requestDto.getContents());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 업습니다. id = " + id));

        return new PostsResponseDto(entity);
    }

    @Transactional //(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional //(readOnly = true)
    public void delete( Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 업습니다. id = " + id));
        postsRepository.delete(posts);
    }
}
