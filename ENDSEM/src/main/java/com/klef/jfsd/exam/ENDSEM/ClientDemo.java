package com.klef.jfsd.exam.ENDSEM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
             
            Transaction transaction = session.beginTransaction();

            // HQL Update Query with Positional Parameters
            String hql = "UPDATE Department SET name = ?1, location = ?2 WHERE departmentId = ?3";
            int updatedEntities = session.createQuery(hql)
                                          .setParameter(1, "Updated Department Name")
                                          .setParameter(2, "Updated Location")
                                          .setParameter(3, 1) // Assuming the Department ID is 1
                                          .executeUpdate();

            System.out.println("Number of records updated: " + updatedEntities);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
