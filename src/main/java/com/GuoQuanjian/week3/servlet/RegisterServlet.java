package com.GuoQuanjian.week3.servlet;

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
    ResultSet resultSet = null;

    @Override
    public void init() throws ServletException {
/*        ServletContext servletContext = getServletContext();
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
        }*/
        connection= (Connection) getServletContext().getAttribute("connection");
        System.out.println(connection);
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
        String insertSql = "insert into usertable values(null,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, birthdate);
            //直接用户名为空则不插入
            if (username != null || password != null || email != null || gender != null || birthdate != null) {
                int result = preparedStatement.executeUpdate();
                System.out.println(result);
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter pw = response.getWriter();
        String selectSql = "select * from usertable";
        try {
            resultSet = preparedStatement.executeQuery(selectSql);
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
            pw.println("<table style=\"border: 1px solid black;\">\n" +
                    "<tr>\n" +
                    " <th>ID</th>\n" +
                    " <th>Username</th>\n" +
                    " <th>Password</th>\n" +
                    " <th>Email</th>\n" +
                    " <th>Gender</th>\n" +
                    " <th>BirthDate</th>\n" +
                    "</tr>\n");
            while (resultSet.next()) {
                String id2 = resultSet.getString("id");
                String username2 = resultSet.getString("username");
                String password2 = resultSet.getString("password");
                String email2 = resultSet.getString("email");
                String gender2 = resultSet.getString("gender");
                String birthdate2 = resultSet.getString("birthdate");
                pw.println(
                        "        <tr>\n" +
                                "  <td>" + id2 + "</td>\n" +
                                "  <td>" + username2 + "</td>\n" +
                                "  <td>" + password2 + "</td>\n" +
                                "  <td>" + email2 + "</td>\n" +
                                "  <td>" + gender2 + "</td>\n" +
                                "  <td>" + birthdate2 + "</td>\n" +
                                "</tr>\n");
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

    @Override
    public void destroy() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
