package ua.goit.jdbc.dao;

public interface DataAccessObject<T> {

    T findById(Integer id);
    void create(T entity);
}
