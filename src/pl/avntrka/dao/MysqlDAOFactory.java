package pl.avntrka.dao;

public class MysqlDAOFactory extends DAOFactory{
    @Override
    public BasketDAO getBasketDAO() {
        return new BasketDAOImpl();
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

    @Override
    public ProductDAO getProductDAO() {
        return new ProductDAOImpl();
    }
}
