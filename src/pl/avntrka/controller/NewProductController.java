package pl.avntrka.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import pl.avntrka.dao.ProductDAOImpl;
import pl.avntrka.model.Product;
import pl.avntrka.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.util.*;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import pl.avntrka.model.User;
import pl.avntrka.service.ProductService;
import pl.avntrka.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@MultipartConfig

@WebServlet("/add")
public class NewProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 9999 * 9999;
    private int maxMemSize = 9999 * 9999;
    private File file ;
    private long productId;

    public void init( ){
        // Get the file location where it would be stored.
        filePath = getServletContext().getInitParameter("file-upload");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");


        User authenticatedUser = (User) request.getSession().getAttribute("user");


        if (request.getUserPrincipal() != null) {



                String name = request.getParameter("inputName");
                System.out.println("Nazwa produktu - " + name);
                String category = request.getParameter("inputCategory");
                String description = request.getParameter("description");
                String pris = request.getParameter("inputPris");
                String brand= request.getParameter("inputBrand");
                String condition= request.getParameter("inputCondition");
                ProductService productService = new ProductService();

            // Process the uploaded file items
            List<Part> fileParts = request.getParts().stream().filter(part -> "fileName".equals(part.getName()) && part.getSize() > 0).collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">


                for (Part filePart : fileParts) {

                    Random random = new Random();
                    long fname=random.nextLong();
                  while (fname<0){
                      fname=random.nextLong();
                  }
                    String fileName = fname+ "";
                    String fieldName = filePart.getSubmittedFileName().toString();
                    InputStream fileContent = filePart.getInputStream();
                    String contentType=filePart.getContentType();
                    // ... (do your job here)
                    file = new File(filePath + fileName + ".jpg" );


                    try {
                       filePart.write(file.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            productService.addProduct(name, description, category, condition, brand, pris, authenticatedUser, file, file.getName());
            System.out.println(file.getName());
        }

        response.sendRedirect(request.getContextPath() + "/");

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        if (request.getUserPrincipal() != null) {

            request.getRequestDispatcher("/newProduct.jsp").forward(request, response);

        } else {
            response.sendError(403);
        }
    }




}
