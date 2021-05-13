package ua.goit.jdbc.dao;

import ua.goit.jdbc.config.DatabaseConnectionManager;
import ua.goit.jdbc.dao.model.LocationDAO;
import ua.goit.jdbc.service.LocationConverter;

import java.sql.*;

public class LocationRepository implements Repository<LocationDAO> {
    private final DatabaseConnectionManager connectionManager;

    private static final String INSERT = "INSERT INTO locations (location_id, street_address, postal_code, " +
            "city, state_province) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_LOCATIONS_BY_ID = "SELECT location_id, street_address, postal_code, " +
            "city, state_province FROM locations WHERE location_id = ?;";
    private static final String UPDATE = "UPDATE locations SET street_address=?, postal_code=?, " +
            "city=?, state_province=? WHERE location_id=?";

    public LocationRepository(DatabaseConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public LocationDAO findById(Integer id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOCATIONS_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return LocationConverter.toLocation(resultSet);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public void create(LocationDAO entity) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getStreetAddress());
            statement.setString(3, entity.getPostalCode());
            statement.setString(4, entity.getCity());
            statement.setString(5, entity.getStateProvince());
            statement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(LocationDAO locationDAO) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, locationDAO.getStreetAddress());
            preparedStatement.setString(2, locationDAO.getPostalCode());
            preparedStatement.setString(3, locationDAO.getCity());
            preparedStatement.setString(4, locationDAO.getStateProvince());
            preparedStatement.setInt(5, locationDAO.getId());
            preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
