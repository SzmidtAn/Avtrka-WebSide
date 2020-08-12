package pl.avntrka.dao;

import pl.avntrka.exception.NoSuchdBTypeException;

public abstract class DAOFactory {

    private static final int MYSQL_DAO_FACTORY = 1;

    public static DAOFactory getDAOFactory() {
        DAOFactory factory=null;
        try {
            factory=getDAOFactory(MYSQL_DAO_FACTORY);
        }catch (NoSuchdBTypeException e){
            e.printStackTrace();
        }
        return factory;
    }

private static DAOFactory getDAOFactory(int type) throws NoSuchdBTypeException {
        switch (type){
            case MYSQL_DAO_FACTORY:
                return new MysqlDAOFactory();
            default:
                throw new NoSuchdBTypeException();
        }
}



    public abstract BasketDAO getBasketDAO();
    public abstract UserDAO getUserDAO();
    public abstract ProductDAO getProductDAO();
}
