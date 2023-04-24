package org.example.service.impl;

import org.example.dao.CourseDao;
import org.example.dao.impl.CourseDaoImpl;
import org.example.entity.Course;
import org.example.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    CourseDao courseDao=new CourseDaoImpl();

    @Override
    public String saveCourse(Course newCourse) {
        return courseDao.saveCourse(newCourse);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public String updateCourse(Long oldId, Course newCourse) {
        return courseDao.updateCourse(oldId,newCourse);
    }

    @Override
    public List<Course> getAllCourses() {
        return null;
    }

    @Override
    public String deleteCourseById(Long id) {
        return null;
    }
}
