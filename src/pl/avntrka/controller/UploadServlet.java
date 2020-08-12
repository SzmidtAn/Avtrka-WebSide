package pl.avntrka.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
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

@MultipartConfig

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
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




            // Check that we have a file upload request
            isMultipart = ServletFileUpload.isMultipartContent(request);
            response.setContentType("text/html");
            java.io.PrintWriter out = response.getWriter( );



            DiskFileItemFactory factory = new DiskFileItemFactory();

            // maximum size that will be stored in memory
            factory.setSizeThreshold(maxMemSize);

            // Location to save data that is larger than maxMemSize.
            factory.setRepository(new File("c:\\temp"));

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // maximum file size to be uploaded.
            upload.setSizeMax( maxFileSize );



            try {
                // Parse the request to get file items.
                List fileItems = upload.parseRequest(request);


                // Process the uploaded file items


                for (Object fileItem : fileItems) {
                    System.out.println("while");
                    FileItem fi = (FileItem) fileItem;
                    if (!fi.isFormField()) {
                        System.out.println("if");


                        // Get the uploaded file parameters
                        String fieldName = fi.getFieldName();
                        String fileName = fi.getName();
                        String contentType = fi.getContentType();
                        boolean isInMemory = fi.isInMemory();
                        long sizeInBytes = fi.getSize();
                        System.out.println("filename " + fileName);
                        System.out.println("fieldname " + fieldName);


                        // Write the file
                        if (fileName.lastIndexOf("\\") >= 0) {
                            file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
                        } else {
                            file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
                        }
                        fi.write(file);

                        Random random = new Random();
                        fileName = request.getQueryString() + random.toString();
                        System.out.println("file name= " + fileName);


                    }
                }





            } catch(Exception ex) {
                System.out.println(ex);
                System.out.println("catch ex");
            }














            response.sendRedirect(request.getContextPath() + "/add");



        } else {
            response.sendError(403);
        }

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
