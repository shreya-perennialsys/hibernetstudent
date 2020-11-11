package com.example.hibernetstudent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
//import spring.jpa.properties.hibernate.*

public class
UpdateStudent {
    public static void main(String args[])
    {
        try {
            StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metadata=new MetadataSources(ssr).getMetadataBuilder().build();
            SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();
            Session session= sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            Student student=session.load(Student.class,1);
            student.setName("Hina");
            session.update(student);
            transaction.commit();
            System.out.println("Successfully update");
            session.close();
            sessionFactory.close();
        }catch (Exception e)
        {
            e.toString();
        }
    }
}
