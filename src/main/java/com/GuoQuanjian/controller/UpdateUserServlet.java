package com.GuoQuanjian.controller;

import com.GuoQuanjian.dao.IUserDao;
import com.GuoQuanjian.dao.UserDao;
import com.GuoQuanjian.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public void init() throws ServletException {
        connection = (Connection) getServletContext().getAttribute("connection");
        System.out.println(connection);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("Email");
        String gender = req.getParameter("gender");
        String birthdate = req.getParameter("Birthdate");
        User user = new User();
        try {
            user.setId(Integer.parseInt(id));
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setGender(gender);
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthdate);
            user.setBirthDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        IUserDao userDao = new UserDao();
        try {
            userDao.updateUser(connection, user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(req,resp);
    }
}
