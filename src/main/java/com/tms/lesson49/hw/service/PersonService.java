package com.tms.lesson49.hw.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tms.lesson49.hw.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class PersonService {

    public Person createUser(Person person) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        session.persist(person);
        t.commit();
        return person;
    }

    public Person getPersonInfo(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.getReference(Person.class, id);
    }

    public Person updatePerson(Person person) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        session.merge(person);
        t.commit();
        return person;
    }

    public void deleteUser(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Person person = session.getReference(Person.class, id);
        Transaction t = session.beginTransaction();
        session.remove(person);
        t.commit();
    }
}
