package com.GuoQuanjian.lab2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",
        urlPatterns = {"/lab2/welcome.jsp",""}
)
//todo 1: map this filter for  - /lab2/validate.jsp and /lab2/welcome.jsp
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        //todo 2: print i am in LoginFilter--init()
        System.out.println("I am in LoginFilter--init()...");
    }

    public void destroy() {
        //todo 3: print i am in LoginFilter--destroy()
        System.out.println("I am in LoginFilter--destroy()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // todo 4: print i am in LoginFilter--doFilter()-- request before chain
        System.out.println("I am in LoginFilter --before chain");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        /*    todo 6: if session not new
          todo 7: forward to lab2/welcome.jsp
          todo 8: else redirect to login.jsp */
        HttpSession session = req.getSession();
        if (session.isNew()) {
            req.getRequestDispatcher("lab2/welcome.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("login.jsp");
        }
        chain.doFilter(request, response);
        // todo 5: print i am in LoginFilter--destroy()-- response after chain
        System.out.println("I am in LoginFilter --after chain");
    }
}
