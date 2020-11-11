package com.example.hibernetstudent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class InsertStudent {
    public static void main(String args[])
    {
        try {
            StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metadata=new MetadataSources(ssr).getMetadataBuilder().build();
            SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();
            Session session= sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            int marks=94;
            String grade;
            Student student=new Student();
            student.setName("nikita");
            //student.setRoll(11);
            student.setMarks(marks);
            if(marks>=41 && marks<=55)
                grade="pass";
            else if(marks>=56 && marks<=65)
                grade="second class";
            else if(marks>=66  && marks<=74)
                grade="First class";
            else if (marks>=75 && marks<=100)
                grade="distinction";
            else
                grade="fail";
            student.setGrade(grade);

            System.out.println(student.getName());
            System.out.println(student.getMarks());
            System.out.println(student.getGrade());
            session.save(student);
            transaction.commit();
            System.out.println(student.getRoll());
            Student student1=session.load(Student.class,15);
            System.out.println(student1.getRoll());
            System.out.println("Successfully insert");
            System.out.println(student.getRoll());
            sessionFactory.close();
        }catch (Exception e)
        {
            e.toString();
        }
    }
}
