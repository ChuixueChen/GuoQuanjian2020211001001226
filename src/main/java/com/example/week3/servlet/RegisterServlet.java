package com.example.week3.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
        String driver = servletContext.getInitParameter("driver");
        String url = servletContext.getInitParameter("url");
        String username = servletContext.getInitParameter("username");
        String password = servletContext.getInitParameter("password");
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("Email");
        String gender = request.getParameter("gender");
        String birthdate = request.getParameter("Birthdate");
        String sql1 = "insert into usertable values(null,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, birthdate);
            int result = preparedStatement.executeUpdate();
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter pw = response.getWriter();
        String sql2 = "select * from usertable";
        try {
            ResultSet resultSet = preparedStatement.executeQuery(sql2);
            pw.println("<html>\n" +
                    "<head>\n" +
                    "    <style>\n" +
                    "        table,\n" +
                    "        th,\n" +
                    "        td {\n" +
                    "            border: 1px solid black;\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "\n" +
                    "<body>");
            pw.println("    <table style=\"border: 1px solid black;\">\n" +
                    "        <tr>\n" +
                    "            <th>ID</th>\n" +
                    "            <th>Username</th>\n" +
                    "            <th>Password</th>\n" +
                    "            <th>Email</th>\n" +
                    "            <th>Gender</th>\n" +
                    "            <th>BirthDate</th>\n" +
                    "        </tr>\n" );
            while (resultSet.next()) {
                String id2 = resultSet.getString("id");
                String username2 = resultSet.getString("username");
                String password2 = resultSet.getString("password");
                String email2 = resultSet.getString("email");
                String gender2 = resultSet.getString("gender");
                String birthdate2 = resultSet.getString("birthdate");
                pw.println(
                        "        <tr>\n" +
                                "            <td>"+id2+"</td>\n" +
                                "            <td>"+username2+"</td>\n" +
                                "            <td>"+password2+"</td>\n" +
                                "            <td>"+email2+"</td>\n" +
                                "            <td>"+gender2+"</td>\n" +
                                "            <td>"+birthdate2+"</td>\n" +
                                "        </tr>\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pw.println("</table>");
        pw.println("</body>\n" +
                "</html>");
        /*pw.println("username: "+username);
        pw.println("password: "+password);
        pw.println("email: "+email);
        pw.println("gender: "+gender);
        pw.println("birthdate: "+birthdate);*/
    }
}
