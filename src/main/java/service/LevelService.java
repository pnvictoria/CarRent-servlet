package service;

import dao.interfaces.MainDAO;
import entity.Level;
import service.interfaces.MainService;

import java.sql.SQLException;
import java.util.List;

public class LevelService implements MainService<Level> {

    private MainDAO<Level> daoLevels;

    public LevelService(MainDAO<Level> daoLabels) {
        this.daoLevels = daoLabels;
    }

    @Override
    public boolean addObject(Level obj) throws SQLException {
//         TODO: изменить проверку, сделать проверку полностью по обьекту или имени
//        Level level = daoLevels.getByItem(obj.getId());
        if (true) {
            daoLevels.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        Level level = daoLevels.getObjectById(id);
        if (level != null)
            daoLevels.deleteObject(id);
    }

    @Override
    public void updateObject(Level obj) {
        daoLevels.updateObject(obj);
    }

    @Override
    public Level getObjectById(int id) throws SQLException {
        return daoLevels.getObjectById(id);
    }

    @Override
    public List<Level> getObjects() throws SQLException {
        return daoLevels.getObjects();
    }

    @Override
    public List<Level> getByItem(Level obj) {
        return null;
    }
}
