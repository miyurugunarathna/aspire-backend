package com.metro16.aspire.repositary;

import com.metro16.aspire.model.ID.SubjectID;
import com.metro16.aspire.model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectsRepository extends JpaRepository<Subjects, SubjectID> {
}
