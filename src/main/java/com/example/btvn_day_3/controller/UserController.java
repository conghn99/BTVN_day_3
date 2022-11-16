package com.example.btvn_day_3.controller;

import com.example.btvn_day_3.model.Course;
import com.example.btvn_day_3.service.CourseService;
import com.example.btvn_day_3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/courses")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<Course> getCourses(@RequestParam Optional<String> type, @RequestParam Optional<String> name, @RequestParam Optional<String> topic) {
        if (type.isPresent()) {
            return userService.getCourseListByType(type.get());
        } else if (name.isPresent()) {
            return userService.getCourseListByName(name.get());
        } else if (topic.isPresent()) {
            return userService.getCourseListByTopic(topic.get());
        } else {
            return userService.getCourseList();
        }
    }

    @GetMapping("{id}")
    public List<Object> getCourseById(@PathVariable int id) {
        return userService.getCourseById(id);
    }
}
