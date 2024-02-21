package com.bazlur.eshoppers.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bazlur.eshoppers.service.ProductService;

import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private ProductService productService;


    @Override
    public void init() throws ServletException {
        this.productService = new ProductService();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
