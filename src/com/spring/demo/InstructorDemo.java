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

//            Instructor dave = new Instructor(
//                    "dave", "darby", "dave@teach.com"
//            );
//            InstructorDetail daveDetail = new InstructorDetail(
//                    "dave.youtube.com", "biking"
//            );
//
//            dave.setInstructorDetail(daveDetail);

            session.beginTransaction();

            int instructorId =2;

            Instructor deletingInstructor = session.get(Instructor.class, instructorId);

            System.out.println("Deleting " + deletingInstructor.getFirstName());

            if (deletingInstructor != null){
                session.delete(deletingInstructor);
            }

            session.getTransaction().commit();

        } catch (Exception e) {
            sessionFactory.close();
        }
    }
}
