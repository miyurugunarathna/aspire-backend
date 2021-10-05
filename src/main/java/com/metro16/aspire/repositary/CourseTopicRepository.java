package com.metro16.aspire.repositary;

import com.metro16.aspire.model.CourseTopic;
import com.metro16.aspire.model.ID.CourseTopicID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseTopicRepository extends JpaRepository<CourseTopic, CourseTopicID> {
}
