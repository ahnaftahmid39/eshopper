package com.bazlur.eshoppers.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bazlur.eshoppers.dto.ProductDTO;
import com.bazlur.eshoppers.repository.DummyProductRepositoryImpl;
import com.bazlur.eshoppers.service.ProductService;
import com.bazlur.eshoppers.service.ProductServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl( new DummyProductRepositoryImpl());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (true) throw new RuntimeException("This is a test exception to check if the error page is working or not.");
        List<ProductDTO> allProducts = productService.findAllProductSortedByName();
        req.setAttribute("products", allProducts);
        req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
    }
}
