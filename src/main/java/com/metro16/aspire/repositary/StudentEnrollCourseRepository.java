package com.metro16.aspire.repositary;

import com.metro16.aspire.model.ID.StudentEnrollID;
import com.metro16.aspire.model.StudentEnrollCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentEnrollCourseRepository extends JpaRepository<StudentEnrollCourse, StudentEnrollID> {
}
