package com.example.jpa.Services;

import com.example.jpa.Model.Course;
import com.example.jpa.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourse() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public Optional<Course> getCourse(String courseId) {
        return courseRepository.findById(courseId);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public Course updateCourse(Course course, String courseId) {
        return courseRepository.save(course);
    }

    public void deleteCourse(String courseId) {
        courseRepository.deleteById(courseId);
    }

}
