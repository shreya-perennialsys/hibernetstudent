package com.example.hibernetstudent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DeleteStudent {
    public static void main(String[] arg) {
        try {
            StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
            SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Student student =session.load(Student.class,9);
            System.out.println(student.getRoll());
            System.out.println(student.getName());
            System.out.println(student.getMarks());
            System.out.println(student.getGrade());
            session.delete(student);
            transaction.commit();
            System.out.println("Deleted insert");
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            e.toString();
        }
    }
}

