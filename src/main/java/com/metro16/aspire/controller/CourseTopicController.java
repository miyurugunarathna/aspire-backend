package com.metro16.aspire.controller;

import com.metro16.aspire.model.CourseTopic;
import com.metro16.aspire.service.CourseTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseTopicController {
    @Autowired
    private CourseTopicService service;

    @PostMapping("/topic/add/{id}")
    public CourseTopic addCourseTopic(@RequestBody CourseTopic topic, @PathVariable int id) {
        return service.saveCourseTopic(topic);
    }

    @GetMapping("/topic/all")
    public List<CourseTopic> findAllCourseTopics() {
        return service.getCourseTopics();
    }

    @GetMapping("/topic/{cid}/{name}/{tid}/{title}")
    public CourseTopic findCourseTopicByID(@PathVariable int cid, @PathVariable String name, @PathVariable int tid, @PathVariable String title) {
        return service.getCourseTopicByID(cid, name, tid, title);
    }

    @PutMapping("/topic/update")
    public CourseTopic updateCourseTopic(@RequestBody CourseTopic topic) {
        return service.updateCourseTopic(topic);
    }

    @DeleteMapping("/topic/delete/{cid}/{name}/{tid}/{title}")
    public String deleteCourseTopic(@PathVariable int cid, @PathVariable String name, @PathVariable int tid, @PathVariable String title) {
        return service.deleteCourseTopic(cid, name, tid, title);
    }
}
