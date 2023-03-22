package com.example.apm_manager.utils.hibernate_factory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateFactoryUtil() {
    }

    public static SessionFactory getSessionFactory(List<Class> targetsAnnotatesClasses) {
        if (sessionFactory == null) {
            try {
                Configuration config = new Configuration();
                config.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
                config.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/APMManagerDB");
                config.setProperty("hibernate.connection.username", "root");
                config.setProperty("hibernate.connection.password", "123");
                config.setProperty("show_sql", "true");
                config.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
                for (Class target : targetsAnnotatesClasses) {
                    config.addAnnotatedClass(target);
                }
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
                sessionFactory = config.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
