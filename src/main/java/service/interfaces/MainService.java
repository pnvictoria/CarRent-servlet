package service.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface MainService<T> {
    boolean addObject(T obj) throws SQLException;

    void deleteObject(int id) throws SQLException;

    void updateObject(T obj);

    T getObjectById(int id) throws SQLException;

    List<T> getObjects() throws SQLException;

    List<T> getByItem(T obj) throws SQLException;
}
