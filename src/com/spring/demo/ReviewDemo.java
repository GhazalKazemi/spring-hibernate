package com.spring.demo;

import com.spring.entity.Course;
import com.spring.entity.Instructor;
import com.spring.entity.InstructorDetail;
import com.spring.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReviewDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Course java = new Course("Java Programming");

            Review review1 = new Review("What an awesome course!");
            Review review2 = new Review("Borriiiiing!");
            Review review3 = new Review("Totally clear");

            java.addReview(review1);
            java.addReview(review2);
            java.addReview(review3);

            session.save(java);


            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
