package ua.goit.jdbc.service;

import ua.goit.jdbc.dao.model.Location;
import ua.goit.jdbc.dto.LocationDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationConverter {
    public static Location toLocation(LocationDTO locationDTO) {
        return new Location(locationDTO.getId(), locationDTO.getStreetAddress(), locationDTO.getPostalCode(),
                locationDTO.getCity(), locationDTO.getStateProvince());
    }

    public static LocationDTO fromLocation(Location location) {
        return new LocationDTO(location.getId(), location.getStreetAddress(), location.getPostalCode(),
                location.getCity(), location.getStateProvince());
    }

    public static Location toLocation(ResultSet resultSet) throws SQLException {
        Location location = new Location();
        while (resultSet.next()) {
            location.setId(resultSet.getInt("location_id"));
            location.setStreetAddress(resultSet.getString("street_address"));
            location.setPostalCode(resultSet.getString("postal_code"));
            location.setCity(resultSet.getString("city"));
            location.setStateProvince(resultSet.getString("state_province"));
        }
        return location;
    }
}
