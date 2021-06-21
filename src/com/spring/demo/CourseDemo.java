package com.spring.demo;

import com.spring.entity.Course;
import com.spring.entity.Instructor;
import com.spring.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CourseDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            int instructorId = 1;
            Instructor tempInstructor = session.get(Instructor.class, instructorId);

            System.out.println("Instructor: " + tempInstructor);
            List<Course> courses = tempInstructor.getCourses();
            System.out.println("Courses: " );
            courses.forEach(System.out::println);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
