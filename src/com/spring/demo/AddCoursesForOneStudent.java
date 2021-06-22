package com.spring.demo;

import com.spring.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForOneStudent {

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
        try {
            session.beginTransaction();
            int studentId = 2;
            Student student = session.get(Student.class, studentId);
            System.out.println("Student courses: " + student.getCourses());
//            Course python = new Course("Python programming");
//            Course php = new Course("PHP programming");
//
//            python.addStudent(student);
//            php.addStudent(student);
//
//            session.save(python);
//            session.save(php);



            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sessionFactory.close();
            session.close();
        }

    }
}
