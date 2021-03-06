package com.lab1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/lifecycle")
public class LifeCycleServlet extends HttpServlet {
    int visitTimes;

    public LifeCycleServlet() {
        System.out.println("I Am from default constructor");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init...");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        visitTimes++;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head><title>lifecycleServlet</title></head>");
        writer.println("<body>");
        writer.println("<div>Since loading,this servlet</div>");
        writer.println("<div>has been accessed  "+visitTimes+" times </div>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
