package com.spring.demo;

import com.spring.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;

public class CourseStudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
//            Course java = new Course("Java Programming");
//            session.save(java);
//            Student john = new Student("John", "Doe", "john@mail.com");
//            Student mary = new Student("Mary", "Public", "mary@mail.com");
//
//            java.addStudent(john);
//            java.addStudent(mary);
//
//            session.save(john);
//            session.save(mary);

            int courseId = 14;
            Course course = session.get(Course.class, courseId);
            session.delete(course);

            session.getTransaction().commit();

        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
