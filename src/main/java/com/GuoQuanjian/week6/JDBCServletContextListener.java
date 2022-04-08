package com.GuoQuanjian.week6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        ServletContext context = sce.getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("contextInitialized=>  "+connection);
            context.setAttribute("connection",connection);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        sce.getServletContext().removeAttribute("connection");
        System.out.println("contextDestroyed...");
    }

}
