package service.interfaces;

import java.util.List;

public interface FilterService<T, R> {
    List<T> getFilteredObjects(R dto);
}
