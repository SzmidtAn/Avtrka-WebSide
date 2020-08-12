package pl.avntrka.dao;

import pl.avntrka.model.Basket;

public interface BasketDAO extends GenericDAO<Basket, Long> {

    public Basket getBasketByUserIdProductId(long userId, long productId);


}
