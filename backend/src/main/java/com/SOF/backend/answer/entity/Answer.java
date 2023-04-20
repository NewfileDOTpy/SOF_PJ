package com.SOF.backend.answer.entity;


import com.SOF.backend.answerComment.entity.AnswerComment;
import com.SOF.backend.member.Entity.Member;
import com.SOF.backend.question.Question;
import com.SOF.backend.questionComment.QComment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @Column(nullable = false)
    private String content;

    @CreatedDate
    private LocalDateTime createDate = LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime modifyDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    //@OneToMany(mappedBy = "answer")
    //private List<AnswerComment> answerComments = new ArrayList<>();
    @OneToMany(mappedBy = "answer")
    private List<AnswerComment> answerComments = new ArrayList<>();

    public Answer(String content, Member member, Question question) {
        this.content = content;
        this.member = member;
        this.question = question;
    }

    public Answer(String content, Long answerId) {
        this.content = content;
        this.answerId = answerId;
    }
}
