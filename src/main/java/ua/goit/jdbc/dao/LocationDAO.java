package ua.goit.jdbc.dao;

import ua.goit.jdbc.dao.model.Location;

import java.sql.Connection;

public class LocationDAO implements DataAccessObject<Location> {
    private final Connection connection;

    public LocationDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Location findById(Integer id) {
        return null;
    }

    @Override
    public Location create(Location entity) {
        return null;
    }
}
