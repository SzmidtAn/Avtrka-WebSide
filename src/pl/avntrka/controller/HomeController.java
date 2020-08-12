package pl.avntrka.controller;

import pl.avntrka.model.Product;
import pl.avntrka.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        saveProductsInRequest(request);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    private void saveProductsInRequest(HttpServletRequest request) {
        ProductService productService=new ProductService();
        List<Product> allProducts =
                productService.getAllProducts((d1, d2) -> d2.getTimestamp().compareTo(d1.getTimestamp()));
        request.setAttribute("products", allProducts);
    }
}
