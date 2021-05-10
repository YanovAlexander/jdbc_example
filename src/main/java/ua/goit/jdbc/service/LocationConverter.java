package ua.goit.jdbc.service;

import ua.goit.jdbc.dao.model.Location;
import ua.goit.jdbc.dto.LocationDTO;

public class LocationConverter {
    public static Location toLocation(LocationDTO locationDTO) {
        return new Location(locationDTO.getId(), locationDTO.getStreetAddress(), locationDTO.getPostalCode(),
                locationDTO.getCity(), locationDTO.getStateProvince());
    }

    public static LocationDTO fromLocation(Location location) {
        return new LocationDTO(location.getId(), location.getStreetAddress(), location.getPostalCode(),
                location.getCity(), location.getStateProvince());
    }
}
