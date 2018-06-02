package br.com.puc.sesmt.factory;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class ConnectionFactory {
    private static final SessionFactory sessionFactory;

    static {
        try {
            
            sessionFactory = new AnnotationConfiguration().configure("br/com/puc/sesmt/factory/hibernate_mysql.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
