package com.spring.demo;

import com.spring.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            //Student tempStudent = new Student("John", "Doe", "john@mail.com");
//            Student mary = new Student("Mary", "Moore", "mary@mail.com");
//            Student kate = new Student("Kate", "Malik", "kate@mail.com");
//            Student jeff = new Student("Jeff", "Match", "jeff@mail.com");
            session.beginTransaction();
//            session.save(mary);
//            session.save(kate);
//            session.save(jeff);
            session.getTransaction().commit();

            // read data
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            List<Student> resultList = session.createQuery("from Student s where s.lastName='Match' " +
                    "OR s.firstName='Mary'").getResultList();

            resultList.forEach(System.out::println);


            session.getTransaction().commit();

            //update data
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Student s set email='doe@mail.com' where s.firstName='John'")
                    .executeUpdate();

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }
}
