package dao.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface FilterDAO<T, R> {
    List<T> getFilteredObjects(R dto) throws SQLException;
}
