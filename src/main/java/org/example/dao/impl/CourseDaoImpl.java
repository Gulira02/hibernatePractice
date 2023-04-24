package org.example.dao.impl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.config.HibernateConfig;
import org.example.dao.CourseDao;
import org.example.entity.Course;
import org.hibernate.HibernateError;
import org.hibernate.Session;

import java.util.List;

public class CourseDaoImpl implements CourseDao {
    EntityManagerFactory entityManagerFactory= HibernateConfig.getEntityManager();
    @Override
    public String saveCourse(Course newCourse) {
     EntityManager entityManager= entityManagerFactory.createEntityManager();
     entityManager.getTransaction().begin();
     entityManager.persist(newCourse);
     entityManager.getTransaction().commit();
     entityManager.close();

        return newCourse+"successfully saved";
    }

    @Override
    public Course getCourseById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        //with method :id
        //Course course=entityManager.find(Course.class,id);
        Query query =entityManager.createQuery("select c from Course  c where  c.id = :id").
                setParameter("id",id);
        Course course = (Course) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }

    @Override
    public String updateCourse(Long oldId, Course newCourse) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("update Course set courName=:courseName," +
                "price=:price where id=:oldId").setParameter("courseName",newCourse.getCourName())
                .setParameter("price",newCourse.getPrice())
                .setParameter("id",oldId);
        query.executeUpdate();
        Course updateCourse = (Course) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();

        return "Course "+oldId+" successfully updated "+updateCourse;
    }

    @Override
    public List<Course> getAllCourses() {
        EntityManager entityManager=HibernateConfig.getEntityManager().createEntityManager();
        entityManager.getTransaction().begin();
        List<Course>courseList=entityManager.createQuery("select  c from Course c", Course.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return courseList;
    }

    @Override
    public String deleteCourseById(Long id) {
        try {
            EntityManager entityManager = HibernateConfig.getEntityManager().createEntityManager();
                entityManager.getTransaction().begin();
                Course course = entityManager.find(Course.class, id);
                entityManager.remove(course);
        }catch (HibernateError e){
            return "Error deleting course with id "+id+":"+e.getMessage();
        }
    return "Course with id "+id+"deleted successfully";
}}
