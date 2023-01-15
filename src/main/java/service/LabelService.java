package service;

import dao.interfaces.MainDAO;
import entity.Label;
import service.interfaces.MainService;

import java.sql.SQLException;
import java.util.List;

public class LabelService implements MainService<Label> {

    private MainDAO<Label> daoLabels;

    public LabelService(MainDAO<Label> daoLabels) {
        this.daoLabels = daoLabels;
    }

    @Override
    public boolean addObject(Label obj) throws SQLException {
        //изменить проверку, сделать проверку полностью по обьекту или имени
        Label label = daoLabels.getObjectById(obj.getId());
        if (true) {
            daoLabels.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        Label label = daoLabels.getObjectById(id);
        if (label != null)
            daoLabels.deleteObject(id);
    }

    @Override
    public void updateObject(Label obj) {
        daoLabels.updateObject(obj);
    }

    @Override
    public Label getObjectById(int id) throws SQLException {
        return daoLabels.getObjectById(id);
    }

    @Override
    public List<Label> getObjects() throws SQLException {
        return daoLabels.getObjects();
    }

    @Override
    public List<Label> getByItem(Label obj) throws SQLException {
        return daoLabels.getByItem(obj);
    }
}
