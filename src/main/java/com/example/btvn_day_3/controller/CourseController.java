package com.example.btvn_day_3.controller;

import com.example.btvn_day_3.exception.NotFoundException;
import com.example.btvn_day_3.model.Course;
import com.example.btvn_day_3.request.UpsertCourseRequest;
import com.example.btvn_day_3.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("admin/courses")
    public List<Course> getCourses() {
        return courseService.getCourseList();
    }

    @GetMapping("admin/courses/{id}")
    public Course getCourseById(@PathVariable int id) {
        Optional<Course> course = courseService.getCourseById(id);
        if(course.isPresent()) {
            return course.get();
        }
        throw new NotFoundException("Not found course with id " + id);
    }

    @PostMapping("admin/courses")
    public Course insertCourse(@Valid @RequestBody UpsertCourseRequest request) {
        return courseService.postCourse(request);
    }

    @PutMapping("admin/courses/{id}")
    public Course updateCourse(@PathVariable int id, @Valid @RequestBody UpsertCourseRequest request) {
        return courseService.updateCourse(id, request);
    }

    @DeleteMapping("admin/courses/{id}")
    public void deleteCourse(@PathVariable int id) {
        Optional<Course> course = courseService.getCourseById(id);
        if(course.isPresent()) {
            courseService.deleteCourse(id);
        } else {
            throw new NotFoundException("Not found course with id " + id);
        }
    }
}
