package com.spring.demo;

import com.spring.entity.Course;
import com.spring.entity.Instructor;
import com.spring.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
            Course python = new Course("Python Programming 101");
//            Instructor dave = new Instructor("dave", "doe", "dave@mail.com");
//            InstructorDetail daveDetail = new InstructorDetail("dave.youtube.com", "biking");
//            dave.setInstructorDetail(daveDetail);
//
//            session.save(dave);
            int instructorId = 1;
            Instructor tempInstructor = session.get(Instructor.class, instructorId);
            tempInstructor.addCourse(python);

            session.save(python);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}