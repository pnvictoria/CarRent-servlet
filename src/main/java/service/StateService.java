package service;

import dao.interfaces.MainDAO;
import entity.Role;
import entity.State;
import service.interfaces.MainService;

import java.sql.SQLException;
import java.util.List;

public class StateService implements MainService<State> {

    private MainDAO<State> daoStates;

    public StateService(MainDAO<State> daoRoles) {
        this.daoStates = daoRoles;
    }

    @Override
    public boolean addObject(State obj) throws SQLException {
        //изменить проверку, сделать проверку полностью по обьекту или имени
        State state = daoStates.getObjectById(obj.getId());
        if (true) {
            daoStates.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        State state = daoStates.getObjectById(id);
        if (state != null)
            daoStates.deleteObject(id);
    }

    @Override
    public void updateObject(State obj) {
        daoStates.updateObject(obj);
    }

    @Override
    public State getObjectById(int id) throws SQLException {
        return daoStates.getObjectById(id);
    }

    @Override
    public List<State> getObjects() throws SQLException {
        return daoStates.getObjects();
    }

    @Override
    public List<State> getByItem(State obj) {
        return null;
    }
}
