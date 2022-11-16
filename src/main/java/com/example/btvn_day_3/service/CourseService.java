package com.example.btvn_day_3.service;

import com.example.btvn_day_3.exception.NotFoundException;
import com.example.btvn_day_3.model.Course;
import com.example.btvn_day_3.repository.CourseRepository;
import com.example.btvn_day_3.request.UpsertCourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourseList() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(int id) {
        return courseRepository
                .findAll()
                .stream()
                .filter(course -> id == course.getId())
                .findFirst();
    }

    public Course postCourse(UpsertCourseRequest request) {
        int id = courseRepository.findAll().get(courseRepository.findAll().size() - 1).getId() +1;
        Course course = new Course(id,
                request.getName(),
                request.getDescription(),
                request.getType(),
                request.getTopics(),
                request.getThumbnail(),
                request.getUserId());
        courseRepository.findAll().add(course);
        return course;
    }

    public Course updateCourse(int id, UpsertCourseRequest request) {
        for (Course course : courseRepository.findAll()) {
            if (course.getId() == id) {
                course.setName(request.getName());
                course.setDescription(request.getDescription());
                course.setType(request.getType());
                course.setTopics(request.getTopics());
                course.setThumbnail(request.getThumbnail());
                course.setUserId(request.getUserId());
                return course;
            }
        }
        throw new NotFoundException("Not found course with id " + id);
    }

    public void deleteCourse(int id) {
        courseRepository.findAll().removeIf(course -> course.getId() == id);
    }
}
