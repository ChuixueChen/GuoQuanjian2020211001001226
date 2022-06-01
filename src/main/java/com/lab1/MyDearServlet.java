package com.lab1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "MyDearServlet", value = "/myDearServletURL")
public class MyDearServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        Enumeration<String> parameterNameList = request.getParameterNames();
        writer.println("<html>");
        writer.println("<head><title>usingServlet</title></head>");
        writer.println("<body>");
        while (parameterNameList.hasMoreElements()) {
            String parameterName =  parameterNameList.nextElement();
            String parameterValue = request.getParameter(parameterName);
            writer.println("<div>"+parameterName+":"+parameterValue+"</div>");
        }
        writer.println("</body>");
        writer.println("</html>");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
