package com.GuoQuanjian.controller;

import com.GuoQuanjian.dao.ProductDao;
import com.GuoQuanjian.model.Category;
import com.GuoQuanjian.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/productDetails")
public class ProductDetailsServlet extends HttpServlet {
    private Connection con = null;

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("connection");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = request.getParameter("id") != null
                ? Integer.parseInt(request.getParameter("id")) : 0;
        ProductDao productDao = new ProductDao();
        if (id==0){
            return;
        }
        try {
            List<Category> categoryList=Category.findAllCateGory(con);
            request.setAttribute("categoryList",categoryList);
            Product product = productDao.findById(id, con);
            request.setAttribute("p",product);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        String path="/WEB-INF/views/productDetails.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
