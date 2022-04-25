package com.GuoQuanjian.week5.demo;

import com.GuoQuanjian.dao.UserDao;
import com.GuoQuanjian.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public void init() throws ServletException {
  /*      ServletContext servletContext = getServletContext();
        String driver = servletContext.getInitParameter("driver");
        String url = servletContext.getInitParameter("url");
        String username = servletContext.getInitParameter("username");
        String password = servletContext.getInitParameter("password");
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        connection = (Connection) getServletContext().getAttribute("connection");
        System.out.println(connection);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserDao userDao = new UserDao();
        try {
            User user = userDao.findByUsernamePassword(connection, username, password);
            if (user != null) {
                System.out.println("rememberMe===>"+req.getParameter("rememberMe"));
                if (req.getParameter("rememberMe")!=null){
                    Cookie usernameCookie = new Cookie("cUsername", user.getUsername());
                    Cookie passwordCookie = new Cookie("cPassword", user.getPassword());
                    Cookie rememberMeCookie = new Cookie("cRememberMe", req.getParameter("rememberMe"));
                    usernameCookie.setMaxAge(60);
                    passwordCookie.setMaxAge(60);
                    rememberMeCookie.setMaxAge(60);
                    resp.addCookie(usernameCookie);
                    resp.addCookie(passwordCookie);
                    resp.addCookie(rememberMeCookie);
                }
                HttpSession session = req.getSession();
                System.out.println("session id-->"+session.getId());
                session.setMaxInactiveInterval(10);
                session.setAttribute("user",user);
                /*Cookie cookie = new Cookie("sessionID", "" + user.getId());
                cookie.setMaxAge(10 * 60);
                resp.addCookie(cookie);*/
//                req.setAttribute("user", user);
                req.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "Username or Password Error!");
                req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*String sql = "select * from usertable where username=? and password=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
//            PrintWriter pw = resp.getWriter();
            if (resultSet.next()) {
                req.setAttribute("id", resultSet.getInt("id"));
                req.setAttribute("username", resultSet.getString("username"));
                req.setAttribute("password", resultSet.getString("password"));
                req.setAttribute("email", resultSet.getString("email"));
                req.setAttribute("gender", resultSet.getString("gender"));
                req.setAttribute("birthdate", resultSet.getDate("birthdate"));
                req.getRequestDispatcher("userInfo.jsp").forward(req, resp);
               *//* pw.println("<h1>Login Success!!!</h1>");
                pw.println("<h1>Welcome,"+username+"</h1>");*//*
            } else {
                req.setAttribute("message", "Username or Password Error!");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
//                pw.println("<h1>Login ERROR!!!</h1>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void destroy() {
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}