package pl.avntrka.service;

import org.springframework.cglib.proxy.Factory;
import pl.avntrka.dao.DAOFactory;
import pl.avntrka.dao.UserDAO;
import pl.avntrka.model.User;

public class UserService {
    public void addUser(String username, String password, String email){
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setActive(true);
        DAOFactory factory=DAOFactory.getDAOFactory();
        UserDAO userDAO=factory.getUserDAO();
        userDAO.create(user);
    }

    public User getUserById(long id){
        User user=null;
        DAOFactory factory=DAOFactory.getDAOFactory();
        UserDAO userDAO=factory.getUserDAO();
        user=userDAO.read(id);
    return user;
    }

    public User getUserByUsername(String username){
        User user=null;
        DAOFactory factory=DAOFactory.getDAOFactory();
        UserDAO userDAO=factory.getUserDAO();
        user=userDAO.getUserByUsername(username);
    return user;
    }
}
