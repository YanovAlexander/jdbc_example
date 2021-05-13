package ua.goit.jdbc.dao;

public interface Repository<T> {

    T findById(Integer id);
    void create(T entity);
}
