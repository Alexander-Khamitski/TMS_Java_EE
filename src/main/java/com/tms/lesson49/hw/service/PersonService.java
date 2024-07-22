package com.tms.lesson49.hw.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tms.lesson49.hw.model.Person;
import com.tms.lesson49.hw.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class PersonService {

    public void createUser(Person person) {
        Person person1 = new Person();
        person1.setId(person.getId());
        person1.setName(person.getName());
        person1.setSurname(person.getSurname());
        person1.setAge(person.getAge());
        person1.setPassportNumber(person.getPassportNumber());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        session.save(person1);
        t.commit();
        System.out.println("Blyat'!");
    }

    public void deleteUser(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Person person = session.load(Person.class, id);
        Transaction t = session.beginTransaction();
        session.delete(person);
        t.commit();
    }

    public Person getPersonInfo(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.load(Person.class, id);
    }

    public boolean updateUser(User user) {
        try {
            Connection connection = PostgresDriverManager.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("update person set surname = ? where id = ?;");
            statement.setString(1, user.getSurname());
            statement.setInt(2, user.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
