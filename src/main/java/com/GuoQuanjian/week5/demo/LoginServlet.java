package com.GuoQuanjian.week5.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
        String driver = servletContext.getInitParameter("driver");
        String url = servletContext.getInitParameter("url");
        String username = servletContext.getInitParameter("username");
        String password = servletContext.getInitParameter("password");
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
            System.out.println(connection);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql="select * from usertable where username=? and password=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            PrintWriter pw=resp.getWriter();
            if (resultSet.next()){
                pw.println("<h1>Login Success!!!</h1>");
                pw.println("<h1>Welcome,"+username+"</h1>");
            }else {
                pw.println("<h1>Login ERROR!!!</h1>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
