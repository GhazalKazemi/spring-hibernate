package com.spring.demo;

import com.spring.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            Student tempStudent = new Student("John", "Doe", "john@mail.com");
            session.beginTransaction();
            session.save(tempStudent);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}