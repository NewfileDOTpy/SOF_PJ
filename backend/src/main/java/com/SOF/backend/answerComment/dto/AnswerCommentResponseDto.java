package com.SOF.backend.answerComment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerCommentResponseDto {
    private Long answerCommentId;
    private String comment;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private Long answerId;
    private Long memberId;
}
