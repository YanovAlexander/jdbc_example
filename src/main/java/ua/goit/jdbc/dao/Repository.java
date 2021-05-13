package ua.goit.jdbc.dao;

import ua.goit.jdbc.dao.model.LocationDAO;

public interface Repository<T> {

    T findById(Integer id);
    void create(T entity);

    void update(LocationDAO locationDAO);

    void delete(int id);
}
