package com.SOF.backend.answer.dto;

import com.SOF.backend.member.Entity.Member;
import com.SOF.backend.question.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerPostDto {
    @NotEmpty(message = "공백이 아니어야 합니다.")
    private String content;
}