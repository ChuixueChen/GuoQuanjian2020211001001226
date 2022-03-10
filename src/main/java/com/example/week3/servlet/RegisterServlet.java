package com.example.week3.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
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
        PrintWriter pw=response.getWriter();
        pw.println("username: "+username);
        pw.println("password: "+password);
        pw.println("email: "+email);
        pw.println("gender: "+gender);
        pw.println("birthdate: "+birthdate);
    }
}
