package pl.avntrka.controller;

import pl.avntrka.service.ProductService;
import pl.avntrka.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String username=request.getParameter("inputUsername");
        String password=request.getParameter("inputPassword");
        String telefonNumbe=request.getParameter("inputTelefonNumber");
        String email=request.getParameter("inputEmail");
        UserService userService=new UserService();
        userService.addUser(username, password, email);
        response.sendRedirect(request.getContextPath() + "/");
    }

}