package com.SOF.backend.questionComment;


import com.SOF.backend.member.Entity.Member;
import com.SOF.backend.question.Question;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QComment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long QCommentId;


    @Column
    private String comment;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime modifiedAt;


    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;


    public void addMember(Member member) {
        this.member = member;
        if (!this.member.getQuestionComments().contains(this)) {
            this.member.getQuestionComments().add(this);
        }
    }


    public void addQuestion(Question question){
        this.question = question;
        if(!this.question.getComments().contains(this)){
            this.question.getComments().add(this);
        }
    }

}
