package com.ssono.diary_project.web.dto;

import com.ssono.diary_project.domain.Posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private String content;
    private Long emotion;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.content = entity.getContent();
        this.emotion = entity.getEmotion();
    }
}
