package com.GuoQuanjian.week4.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConfigDemoServlet", urlPatterns = "/config",
        initParams = {
                @WebInitParam(name = "name", value = "GuoQuanjian"),
                @WebInitParam(name = "studentId", value = "2020211001001226")
        }
)
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        省略了(this) this.getServletConfig().getInitParameter
        String name = getServletConfig().getInitParameter("name");
        String studentId = getServletConfig().getInitParameter("studentId");
        PrintWriter pw = resp.getWriter();
        pw.println("name:      " + name);
        pw.println("studentId: " + studentId);
    }
}
