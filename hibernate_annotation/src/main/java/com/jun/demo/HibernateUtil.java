package com.jun.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.*;

/**
 * @author http://www.cnblogs.com/leiOOlei/p/3376155.html
 * 用Maven创建Hibernate项目
 *
 */

public class HibernateUtil {
    
    private static final SessionFactory sessionFactory = buildSessionFactory();
     
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {

        return sessionFactory;
    }
 
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

}
