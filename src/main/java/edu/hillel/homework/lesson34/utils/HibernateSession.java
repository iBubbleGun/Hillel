package edu.hillel.homework.lesson34.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSession implements AutoCloseable {

    private static SessionFactory sessionFactory;

    private HibernateSession() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                final Configuration config = new Configuration().configure("hibernate.cfg.xml");
                config.addAnnotatedClass(edu.hillel.homework.lesson34.models.Student.class);
                config.addAnnotatedClass(edu.hillel.homework.lesson34.models.Subject.class);
                final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
                sessionFactory = config.buildSessionFactory(builder.build());
            } catch (Exception e) {
                throw new RuntimeException("Error building the Session Factory: " + e.getMessage(), e);
            }
        }
        return sessionFactory;
    }

    @Override
    public void close() throws Exception {
        sessionFactory.close();
    }
}
