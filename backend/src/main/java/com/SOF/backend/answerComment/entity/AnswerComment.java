package com.SOF.backend.answerComment.entity;

import com.SOF.backend.answer.entity.Answer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class AnswerComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private String comment;
    @CreatedDate
    private LocalDateTime createDate = LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime modifyDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "ANSWER_ID")
    private Long answerId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Long memberId;

    public AnswerComment(String comment, Long memberId, Long answerId) {
        this.comment = comment;
        this.memberId = memberId;
        this.answerId = answerId;
    }

    public AnswerComment(String comment, Long commentId) {
        this.comment = comment;
        this.commentId = commentId;
    }
}
