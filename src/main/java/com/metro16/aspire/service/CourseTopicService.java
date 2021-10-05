package com.metro16.aspire.service;

import com.metro16.aspire.model.CourseTopic;
import com.metro16.aspire.model.ID.CourseID;
import com.metro16.aspire.model.ID.CourseTopicID;
import com.metro16.aspire.model.ID.SubjectID;
import com.metro16.aspire.repositary.CourseTopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseTopicService {
    @Autowired
    private CourseTopicRepository topicRepository;

    public CourseTopic saveCourseTopic(CourseTopic topic) {
        return topicRepository.save(topic);
    }

    public List<CourseTopic> getCourseTopics() {
        return topicRepository.findAll();
    }

    public CourseTopic getCourseTopicByID(int cid, String name, int tid, String title) {
        return topicRepository.findById(new CourseTopicID(new CourseID(new SubjectID(cid, name), tid), title)).orElse(null);
    }

    public String deleteCourseTopic(int cid, String name, int tid, String title) {
        topicRepository.deleteById(new CourseTopicID(new CourseID(new SubjectID(cid, name), tid), title));
        return "CourseTopic deleted by title: " + title;
    }

    public CourseTopic updateCourseTopic(CourseTopic topic) {
        CourseTopic existingCourseTopic = topicRepository.findById(topic.getCourseTopicID()).orElse(null);
        existingCourseTopic.setDescription(topic.getDescription());
        return topicRepository.save(existingCourseTopic);
    }
}
