package pl.avntrka.controller;

import pl.avntrka.model.Product;
import pl.avntrka.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/productCard")
public class ProductCardController extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        saveProductsInRequest(request);
        request.getRequestDispatcher("productCard.jsp").forward(request, response);
    }

    private void saveProductsInRequest(HttpServletRequest request) throws IOException {
        ProductService productService=new ProductService();
        List<Product> allProducts=productService.getAllProducts((p1, p2) ->p2.getTimestamp().compareTo(p1.getTimestamp()));
        request.setAttribute("products", allProducts);

    }
}
