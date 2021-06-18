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
            //Student tempStudent = new Student("John", "Doe", "john@mail.com");
            Student mary = new Student("Mary", "Moore", "mary@mail.com");
            Student kate = new Student("Kate", "Malik", "kate@mail.com");
            Student jeff = new Student("Jeff", "Match", "jeff@mail.com");
            session.beginTransaction();
            session.save(mary);
            session.save(kate);
            session.save(jeff);
            session.getTransaction().commit();

            // read data
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Student student = session.get(Student.class, mary.getId());
            System.out.println("Read from the database: " + student);
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }
}
