package com.sgf.app.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.sgf.app.repository.CourseRepository;
import com.sgf.app.model.Course;
import com.sgf.app.model.User;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> findByUser(User user) {
        return repository.findByUser(user);
    }

    public Course save(Course course, User user) {
        course.setUser(user);
        return repository.save(course);
    }
}