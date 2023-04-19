package com.SOF.backend.question;

import com.SOF.backend.questionComment.QComment;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;


public class QuestionDto {


    @Getter
    public static class Create {


        @NotBlank
        @Pattern(regexp = "^.{2,}$",
                message = "최소 두 글자 이상 작성해야 합니다.")
        private String title;

        @NotBlank
        @Pattern(regexp = "^.{20,}$",
        message = "20자 이상 작성해야 합니다.")
        private String content;

        @Nullable
        private Blob contentImg;

    }



    @Getter
    public static class Update {


        private String title;


        private String content;

        private Blob contentImg;
    }


    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response{

        private Long questionId;

        private String title;

        private String content;

        private Blob contentImg;

        private LocalDateTime createdAt;

        private LocalDateTime modifiedAt;

        private int viewed;

        private List<QComment> questionComment;
    }

    @Getter
    public static class QuestionPageResponse<T>{
        private List<T> data;
        private QuestionPage questionPage;

        public QuestionPageResponse(List<T> data, Page page) {
            this.data = data;
            this.questionPage = new QuestionPage(page.getNumber() +1,
                    page.getSize(), page.getTotalElements(), page.getTotalPages());
        }
    }



}
