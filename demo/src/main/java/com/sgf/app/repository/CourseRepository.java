package com.sgf.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sgf.app.model.Course;
import com.sgf.app.model.User;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByUser(User user);
}