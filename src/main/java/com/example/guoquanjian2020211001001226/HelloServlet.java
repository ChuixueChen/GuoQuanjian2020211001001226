package com.example.guoquanjian2020211001001226;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public HelloServlet() {
        System.out.println("构造器");
    }

    public void init() {
        message = "Hello World!";
        System.out.println("init");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("This is my JSP homework!");
        out.println("</body></html>");
        System.out.println("service");
    }

    public void destroy() {
        System.out.println("destroy");
    }
}