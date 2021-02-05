package com.ssono.diary_project.service;

import com.ssono.diary_project.domain.Posts.Posts;
import com.ssono.diary_project.domain.Posts.PostsRepository;
import com.ssono.diary_project.web.dto.PostsSaveRequestDto;
import com.ssono.diary_project.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service

public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    // 저장
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    // 수정
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 일기가 없습니다. id=" + id));
        //
        posts.update(requestDto.getContent(), requestDto.getEmotion());

        return id;
    }
}
