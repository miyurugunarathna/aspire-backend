package com.metro16.aspire.repositary;

import com.metro16.aspire.model.Course;
import com.metro16.aspire.model.ID.CourseID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, CourseID> {
}
