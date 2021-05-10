package ua.goit.jdbc.dao;

import ua.goit.jdbc.config.DatabaseConnectionManager;
import ua.goit.jdbc.dao.model.Location;
import ua.goit.jdbc.service.LocationConverter;

import java.sql.*;

public class LocationDAO implements DataAccessObject<Location> {
    private final DatabaseConnectionManager connectionManager;

    private static final String INSERT = "INSERT INTO locations (location_id, street_address, postal_code, " +
            "city, state_province) VALUES (%s, '%s', '%s', '%s', '%s');";
    private static final String SELECT_LOCATIONS_BY_ID = "SELECT location_id, street_address, postal_code, " +
            "city, state_province FROM locations WHERE location_id = ?;";

    public LocationDAO(DatabaseConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public Location findById(Integer id) {
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
    public void create(Location entity) {
        try (Connection connection = connectionManager.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(String.format(INSERT, entity.getId(), entity.getStreetAddress(),
                    entity.getPostalCode(), entity.getCity(), entity.getStateProvince()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
