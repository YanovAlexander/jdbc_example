package ua.goit.jdbc.dao;

import ua.goit.jdbc.config.DatabaseConnectionManager;
import ua.goit.jdbc.dao.model.Location;

public class LocationDAO implements DataAccessObject<Location> {
    private final DatabaseConnectionManager connectionManager;

    public LocationDAO(DatabaseConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
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
