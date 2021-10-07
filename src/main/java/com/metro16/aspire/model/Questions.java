package com.metro16.aspire.model;

import com.metro16.aspire.model.ID.SubjectID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "question")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionID;
    private String title;
    private String description;
    private Date date;
    @Embedded
    private SubjectID subjectID;

    @OneToMany
    @JoinColumn(name = "questionID")
    @ToString.Exclude
    private List<Reply> replies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Questions questions)) return false;
        return getQuestionID() == questions.getQuestionID() && Objects.equals(getTitle(), questions.getTitle()) && Objects.equals(getDescription(), questions.getDescription()) && Objects.equals(getDate(), questions.getDate()) && Objects.equals(getSubjectID(), questions.getSubjectID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestionID(), getTitle(), getDescription(), getDate(), getSubjectID());
    }
}
