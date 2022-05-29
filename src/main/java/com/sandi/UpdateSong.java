package com.sandi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateSong {

    public static void main(String[] args){

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Song.class);

        final SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Song song = session.get(Song.class, 2);
        System.out.println("Song name : " + song.getSongName());
        song.setSongName("butterfly effect");
        song.setArtist("travis scott");
        //session.save(song);
        session.getTransaction().commit();
        session.close();

        song.setSongName("highest in the room");

        Session newSession = sessionFactory.openSession();
        newSession.beginTransaction();
        Song song2 = newSession.get(Song.class, 2);
        newSession.update(song);
        newSession.getTransaction().commit();
        newSession.close();

    }

}
