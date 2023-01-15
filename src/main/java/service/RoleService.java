package service;

import dao.interfaces.MainDAO;
import entity.Role;
import service.interfaces.MainService;

import java.sql.SQLException;
import java.util.List;

public class RoleService implements MainService<Role> {

    private MainDAO<Role> daoRoles;

    public RoleService(MainDAO<Role> daoRoles) {
        this.daoRoles = daoRoles;
    }

    @Override
    public boolean addObject(Role obj) throws SQLException {
        //изменить проверку, сделать проверку полностью по обьекту или имени
        Role role = daoRoles.getObjectById(obj.getId());
        if (true) {
            daoRoles.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        Role role = daoRoles.getObjectById(id);
        if (role != null)
            daoRoles.deleteObject(id);
    }

    @Override
    public void updateObject(Role obj) {
        daoRoles.updateObject(obj);
    }

    @Override
    public Role getObjectById(int id) throws SQLException {
        return daoRoles.getObjectById(id);
    }

    @Override
    public List<Role> getObjects() throws SQLException {
        return daoRoles.getObjects();
    }

    @Override
    public List<Role> getByItem(Role obj) {
        return null;
    }
}
