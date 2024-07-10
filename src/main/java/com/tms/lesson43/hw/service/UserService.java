package com.tms.lesson43.hw.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tms.lesson43.hw.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserService {

    public boolean createUser(User user) {
        try {
            Connection connection = PostgresDriverManager.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "insert into person (id, name, surname, age, passport_number) values (?, ?, ?, ?, ?);");
            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getSurname());
            statement.setInt(4, user.getAge());
            statement.setString(5, user.getPassportNumber());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUserInfo(int id) {
        try {
            Connection connection = PostgresDriverManager.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setAge(resultSet.getInt("age"));
                user.setPassportNumber(resultSet.getString("passport_number"));
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
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

    public boolean deleteUser(int id) {
        try {
            Connection connection = PostgresDriverManager.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from person where id = ?;");
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
