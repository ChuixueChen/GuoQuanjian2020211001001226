package com.lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/calServlet")
public class CalServlet extends HttpServlet {

    //       todo 1: create a method to add(int firstVal, int secondVal) two number
    public int add(int firstVal, int secondVal) {
        return firstVal + secondVal;
    }

    //        todo 2: create a method to subtract two number
    public int subtract(int firstVal, int secondVal) {
        return firstVal - secondVal;
    }

    //        todo 3: create a method to multiply two number
    public int multiply(int firstVal, int secondVal) {
        return firstVal * secondVal;
    }

    //        todo 4: create a method to divide two number
    public double divide(int firstVal, int secondVal) {
        return firstVal / secondVal;
    }

    //        todo 5: create a method to computeLength of a string
    public int computeLength(String value) {
        return value.length();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        todo 6: get all request parameters- firstValue , secondValue,name,action
        int firstVal = request.getParameter("firstVal") != null ? Integer.valueOf(request.getParameter("firstVal")) : 0;
        int secondVal = request.getParameter("secondVal") != null ? Integer.valueOf(request.getParameter("secondVal")) : 0;
        String name = request.getParameter("name");
        String action = request.getParameter("action");
//        todo 7: use if else to determine action is add or subtract or multiply or divide or computerLength
        int result = 0;
        //        todo 8 : call method add, subtract , multiply, divide or computeLength based on action and get the calculated result
        if (action.equals("add")) {
            result = add(firstVal, secondVal);
        } else if (action.equals("subtract")) {
            result = subtract(firstVal, secondVal);
        } else if (action.equals("multiply")) {
            result = multiply(firstVal, secondVal);
        } else if (action.equals("divide")) {
            result = (int) divide(firstVal, secondVal);
        } else if (action.equals("computeLength")) {
            result = computeLength(name);
        }
//        todo 9: if action =add or subtract or multiply or divide
        if (action.equals("add")||action.equals("subtract")||action.equals("multiply")||action.equals("divide")){
            //        todo 10 :create 3 cookie name cFirstValue, cSecondValue,cResult and set the value of cookie
            Cookie cFirstValue = new Cookie("cFirstValue",request.getParameter("firstVal"));
            Cookie cSecondValue = new Cookie("cSecondValue",request.getParameter("secondVal"));
            Cookie cResult = new Cookie("cResult",String.valueOf(result));
            cFirstValue.setMaxAge(3);
            cSecondValue.setMaxAge(3);
            cResult.setMaxAge(3);
 //        todo 11 : add 3 cookies into response
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        }
        //        todo 12: if action =computeLength
        else if (action.equals("computeLength")){
            //        todo 13 :create 2 cookies name cName, cLength and set the value
            Cookie cName = new Cookie("cName", request.getParameter("name"));
            Cookie cLength = new Cookie("cLength", String.valueOf(result));
            cName.setMaxAge(3);
            cLength.setMaxAge(3);
            //        todo 14 : add 2 cookies into response
            response.addCookie(cName);
            response.addCookie(cLength);
        }
//        todo 15 : send redirect to cal.jsp
        response.sendRedirect(request.getContextPath()+"/Lab3/cal.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
