package com.SOF.backend.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor

public class AnswerResponseDto {
    private Long answerId;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private Long questionId;
    private Long memberId;
}

