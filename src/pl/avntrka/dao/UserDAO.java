package pl.avntrka.dao;

import pl.avntrka.model.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User,Long> {

    List<User> getAll();
    User getUserByUsername(String username);

}
