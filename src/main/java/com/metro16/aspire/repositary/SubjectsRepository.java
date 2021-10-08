package com.metro16.aspire.repositary;

import com.metro16.aspire.model.ID.SubjectID;
import com.metro16.aspire.model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectsRepository extends JpaRepository<Subjects, SubjectID> {
    List<Subjects> findAllBySubjectIDClassID(int cid);
}
