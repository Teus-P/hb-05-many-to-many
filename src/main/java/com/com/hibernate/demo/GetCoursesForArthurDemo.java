package com.com.hibernate.demo;

import com.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesForArthurDemo {

    public static void main(String[] args){

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            int id = 2;

            Student arthur = session.get(Student.class, id);

            System.out.println("Loaded student: " + arthur);
            System.out.println("Courses: " + arthur.getCourses());


            session.getTransaction().commit();
            System.out.println("Done.");

        }finally {
            session.close();
            factory.close();
        }
    }
}
