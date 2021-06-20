package com.spring.demo;

import com.spring.entity.Instructor;
import com.spring.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InstructorDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            Instructor dave = new Instructor(
                    "dave", "darby", "dave@teach.com"
            );
            InstructorDetail daveDetail = new InstructorDetail(
                    "dave.youtube.com", "biking"
            );

            dave.setInstructorDetail(daveDetail);

            session.beginTransaction();

            session.save(dave);

            session.getTransaction().commit();

        } catch (Exception e) {
            sessionFactory.close();
        }
    }
}
