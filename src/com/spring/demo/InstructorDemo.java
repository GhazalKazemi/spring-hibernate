package com.spring.demo;

import com.spring.entity.Instructor;
import com.spring.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLOutput;

public class InstructorDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            Instructor mandy = new Instructor(
                    "mandy", "moore", "mandy@teach.com"
            );
            InstructorDetail mandyDetail = new InstructorDetail(
                    "mandy.youtube.com", "dancing"
            );

            mandyDetail.setInstructor(mandy);

            session.beginTransaction();

            session.save(mandyDetail);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
