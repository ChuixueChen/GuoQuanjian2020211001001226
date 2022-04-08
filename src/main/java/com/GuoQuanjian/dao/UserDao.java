package com.GuoQuanjian.dao;

import com.GuoQuanjian.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao {
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql = "insert into usertable values(null,?,?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getGender());
        preparedStatement.setDate(5, (java.sql.Date) user.getBirthDate());
        int result = preparedStatement.executeUpdate();
        if (result != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql = "delete from usertable where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, user.getId());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql = "update usertable set username=?,password=?,email=?,gender=?,birthdate=? where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getGender());
        preparedStatement.setDate(5, (java.sql.Date) user.getBirthDate());
        preparedStatement.setInt(6, user.getId());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql = "select * from usertable where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = null;
        if (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql = "select * from usertable where username=? and password=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = null;
        if (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql = "select * from usertable where username=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> userList=null;
        User user = null;
        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql = "select * from usertable where password=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> userList=null;
        User user = null;
        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql = "select * from usertable where email=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> userList=null;
        User user = null;
        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql = "select * from usertable where gender=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, gender);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> userList=null;
        User user = null;
        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql = "select * from usertable where birthdate=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setDate(1, (java.sql.Date) birthDate);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> userList=null;
        User user = null;
        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql = "select * from usertable";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> userList=null;
        User user = null;
        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }
}
