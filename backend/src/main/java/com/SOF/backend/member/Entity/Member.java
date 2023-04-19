/*
* 파일명 : Member.class
* 목적 : Member의 엔티티를 관리하기 위한 클래스
* 파일 생성일 : 2023.04.15
* 마지막 편집일 : 2023.04.17
* 마지막 편집자 : 이호준
* */


package com.SOF.backend.member.Entity;

import com.SOF.backend.answer.entity.Answer;
import com.SOF.backend.answerComment.entity.AnswerComment;
import com.SOF.backend.question.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;  // 기본 키

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column
    @Lob    // 이미지를 blob 형태로 저장하는 애너테이션
    private byte[] image;

    @Column
    private String location;

    @Column(nullable = false)
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime latestLog =  LocalDateTime.now();

    @Column(nullable = false)
    private int visited = 0;

    @OneToMany(mappedBy = "member")
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Answer> answers = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<AnswerComment> answerComments = new ArrayList<>();

    public Member(String email, String nickname, String password, byte[] image, String location) {
        this.email = email;
        this.nickname = nickname;
        this.image = image;
        this.password = password;
        this.location = location;
    }

    public Member(long memberId, String email, String nickname, byte[] blobToByteArray, String location) {
        this.memberId = memberId;
        this.email = email;
        this.nickname = nickname;
        this.image = blobToByteArray;
        this.location = location;
    }

    public Member(long memberId, String email, String nickname, String location) {
        this.memberId = memberId;
        this.email = email;
        this.nickname = nickname;
        this.location = location;
    }

    public void addQuestion(Question question){
        questions.add(question);
    }

    public void addAnswer(Answer answer){
        answers.add(answer);
    }

    public void addAnswerComment(AnswerComment answerComment){
        answerComments.add(answerComment);
    }
}

