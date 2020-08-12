package pl.avntrka.dao;

import pl.avntrka.model.Product;
import pl.avntrka.model.User;

import java.util.List;

public interface ProductDAO extends GenericDAO<Product, Long> {

    List<Product> getAll();
    Product getProductById(long id);
}
