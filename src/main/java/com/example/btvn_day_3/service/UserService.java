package com.example.btvn_day_3.service;

import com.example.btvn_day_3.model.Course;
import com.example.btvn_day_3.model.User;
import com.example.btvn_day_3.repository.CourseRepository;
import com.example.btvn_day_3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Course> getCourseList() {

        return courseRepository.findAll();
    }

    public List<Course> getCourseListByType(String type) {
        return courseRepository
                .findAll()
                .stream()
                .filter(course -> course.getType().equals(type))
                .collect(Collectors.toList());
    }

    public List<Course> getCourseListByName(String name) {
        return courseRepository
                .findAll()
                .stream()
                .filter(course -> course.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<Course> getCourseListByTopic(String topics) {
        return courseRepository
                .findAll()
                .stream()
                .filter(course -> course.getTopics().contains(topics))
                .collect(Collectors.toList());
    }

    public List<Object> getCourseById(int id) {
        Course course = courseRepository
                .findAll()
                .stream()
                .filter(course1 -> id == course1.getId())
                .findFirst()
                .orElse(null);
        User user = userRepository
                .findAll()
                .stream()
                .filter(user1 -> course.getUserId() == user1.getId())
                .findFirst()
                .orElse(null);
        return Arrays.asList(course, user);
    }
}
