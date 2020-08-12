package pl.avntrka.dao;

import pl.avntrka.model.Basket;

import java.util.List;

public class BasketDAOImpl implements BasketDAO {
    @Override
    public Basket getBasketByUserIdProductId(long userId, long productId) {
        return null;
    }

    @Override
    public Basket create(Basket newObject) {
        return null;
    }

    @Override
    public Basket read(Long primaryKey) {
        return null;
    }

    @Override
    public boolean update(Basket updateObject) {
        return false;
    }

    @Override
    public boolean delete(Long key) {
        return false;
    }

    @Override
    public List<Basket> getAll() {
        return null;
    }
}
