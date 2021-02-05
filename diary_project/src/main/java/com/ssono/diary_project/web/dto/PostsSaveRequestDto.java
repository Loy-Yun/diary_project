package com.ssono.diary_project.web.dto;

import com.ssono.diary_project.domain.Posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor

public class PostsSaveRequestDto {
    private String content;
    private Long emotion;
    private LocalDateTime createdTimeAt;
    private LocalDateTime updateTimeAt;

    @Builder
    public PostsSaveRequestDto(String content, Long emotion) {
        this.content = content;
        this.emotion = emotion;
        final LocalDateTime now = LocalDateTime.now();
        createdTimeAt = now;
        updateTimeAt = now;
    }

    public Posts toEntity() {
        return Posts.builder()
                .emotion(emotion)
                .content(content)
                .build();
    }
}
