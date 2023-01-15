package service;

import dao.interfaces.MainDAO;
import entity.User;
import service.interfaces.MainService;

import java.sql.SQLException;
import java.util.List;

public class UserService implements MainService<User> {

    private MainDAO<User> daoUser;

    public UserService(MainDAO<User> daoUser) {
        this.daoUser = daoUser;
    }

    @Override
    public boolean addObject(User obj) throws SQLException {
        //TODO: изменить проверку, сделать проверку полностью по обьекту или логину
//        User user = daoUser.getObjectById(obj.getId());
//        if (user == null) {
        if (true) {
            daoUser.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        User user = daoUser.getObjectById(id);
        if (user != null)
            daoUser.deleteObject(id);
    }

    @Override
    public void updateObject(User obj) {
        daoUser.updateObject(obj);
    }

    @Override
    public User getObjectById(int id) throws SQLException {
        return daoUser.getObjectById(id);
    }

    @Override
    public List<User> getObjects() throws SQLException {
        return daoUser.getObjects();
    }

    @Override
    public List<User> getByItem(User obj) throws SQLException {
        return daoUser.getByItem(obj);
    }
}
