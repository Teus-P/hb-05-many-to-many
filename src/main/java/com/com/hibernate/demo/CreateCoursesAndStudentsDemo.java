package com.com.hibernate.demo;

import com.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudentsDemo {

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

            Course course = new Course("Pacman");

            System.out.println("Saving course...");
            session.save(course);
            System.out.println("Saved " + course);

            Student student1 = new Student("John","Adam","john@email.com");
            Student student2 = new Student("Arthur","Mac","arthur@email.com");

            course.addStudent(student1);
            course.addStudent(student2);

            System.out.println("Saving students...");
            session.save(student1);
            session.save(student2);
            System.out.println("Done.");

            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }
}
