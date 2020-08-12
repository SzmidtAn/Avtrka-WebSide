package pl.avntrka.service;

import pl.avntrka.dao.DAOFactory;
import pl.avntrka.dao.ProductDAO;
import pl.avntrka.dao.ProductDAOImpl;
import pl.avntrka.dao.UserDAO;
import pl.avntrka.model.Product;
import pl.avntrka.model.User;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ProductService {

    public long getProdsId(Product product){

        return 0;
    }

    public void addProduct(String name, String description, String category,
                           String condition, String brand, String pris, User user, File file, String pictureName){

        Product product= createProductObject(name, description, category, user, pris, brand, condition, pictureName );
        product.setBrand(brand);
        product.setFile(file);


        DAOFactory factory=DAOFactory.getDAOFactory();
        ProductDAO productDAO=factory.getProductDAO();
        productDAO.create(product);

    }

    public void addProductsPictures(long productId, File file){

        Product product=null;
        ProductDAOImpl productDAOimpl=new ProductDAOImpl();
        product=productDAOimpl.getProductById(productId);
        product.setFile(file);

    }

    public Product createProductObject(String name, String description, String category, User user,
                                       String pris, String brand, String condition, String pictureName  ){

        Product product=new Product();
        product.setName(name);
        product.setDescription(description);
        product.setCategory(category);
        product.setPris(pris);
        product.setCondition(condition);
        product.setBrand(brand);
        User userCopy=new User(user);
        product.setUser(user);
        product.setPictureName(pictureName);
        product.setTimestamp(new Timestamp(new Date().getTime()));
        return product;
}

    public List<Product> getAllProducts(){
        return  getAllProducts(null);
    }


    public List<Product> getAllProducts(Comparator<Product> comparator){
        DAOFactory factory=DAOFactory.getDAOFactory();
        ProductDAO productDAO=factory.getProductDAO();
        List<Product> products=productDAO.getAll();
        if (comparator != null && products !=null){
            products.sort(comparator);
        }



        return products;
    }


    }
