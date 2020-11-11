package com.example.hibernetstudent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class SearchStudent {
    public static void main(String[] arg) {

        try {
            StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
            SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            String name="surbhi";
            Student student =session.load(Student.class,8);
            System.out.println(student.getRoll());
            System.out.println(student.getName());
            System.out.println(student.getMarks());
            System.out.println(student.getGrade());
            session.delete(student);
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            e.toString();
        }
    }
}



