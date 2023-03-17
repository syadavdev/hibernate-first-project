package com.sandi.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Song.class);

        final SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Song song1 = new Song();
        //song1.setId(1);
        song1.setSongName("women");
        song1.setArtist("doja cat");

        session.beginTransaction();
        session.save(song1);
        session.getTransaction().commit();

        session.close();

    }
}
