package ua.goit.jdbc.service;

import ua.goit.jdbc.dao.model.LocationDAO;
import ua.goit.jdbc.dto.LocationDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationConverter {
    public static LocationDAO toLocation(LocationDTO locationDTO) {
        return new LocationDAO(locationDTO.getId(), locationDTO.getStreetAddress(), locationDTO.getPostalCode(),
                locationDTO.getCity(), locationDTO.getStateProvince());
    }

    public static LocationDTO fromLocation(LocationDAO locationDAO) {
        return new LocationDTO(locationDAO.getId(), locationDAO.getStreetAddress(), locationDAO.getPostalCode(),
                locationDAO.getCity(), locationDAO.getStateProvince());
    }

    public static LocationDAO toLocation(ResultSet resultSet) throws SQLException {
        LocationDAO locationDAO = new LocationDAO();
        while (resultSet.next()) {
            locationDAO.setId(resultSet.getInt("location_id"));
            locationDAO.setStreetAddress(resultSet.getString("street_address"));
            locationDAO.setPostalCode(resultSet.getString("postal_code"));
            locationDAO.setCity(resultSet.getString("city"));
            locationDAO.setStateProvince(resultSet.getString("state_province"));
        }
        return locationDAO;
    }
}
