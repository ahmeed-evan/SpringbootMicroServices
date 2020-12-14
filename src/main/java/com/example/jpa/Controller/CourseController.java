package com.example.jpa.Controller;

import com.example.jpa.Model.Course;
import com.example.jpa.Model.Topic;
import com.example.jpa.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course>getAllCourses(@PathVariable String topicId){
        return courseService.getAllCourse(topicId);
    }


    @RequestMapping("/topics/{topicId}/courses/{courseId}")
    public Optional<Course> getCourse(@PathVariable String courseId){
        return courseService.getCourse(courseId);
    }


    @RequestMapping(method = RequestMethod.POST,value = "/topics/topicId/courses")
    public void addCourse(@RequestBody Course course,@PathVariable String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/topics/{topicId}/courses/{courseId}")
    public Course updateCourse(@RequestBody Course course,@PathVariable String topicId,@PathVariable String courseId){
        return courseService.updateCourse(course,courseId);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/topics/{topicId}/courses/{courseId}")
    public void deleteCourse(@PathVariable String courseId){
        courseService.deleteCourse(courseId);
    }

}
