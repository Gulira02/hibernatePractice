package org.example;

import org.example.entity.Course;
import org.example.service.CourseService;
import org.example.service.impl.CourseServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        CourseService courseService=new CourseServiceImpl();
       // System.out.println(courseService.saveCourse(new Course("Js", 14000)));
       // System.out.println(courseService.getCourseById(4L));
        courseService.updateCourse(2l,new Course("Go",23000));

    }
}
