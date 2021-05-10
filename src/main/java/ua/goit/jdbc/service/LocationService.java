package ua.goit.jdbc.service;

import ua.goit.jdbc.dao.DataAccessObject;
import ua.goit.jdbc.dao.model.Location;
import ua.goit.jdbc.dto.LocationDTO;

public class LocationService {

    private DataAccessObject<Location> repository;

    public LocationService(DataAccessObject<Location> repository) {
        this.repository = repository;
    }

    public LocationDTO create(LocationDTO locationDTO) {
        Location location = LocationConverter.toLocation(locationDTO);
        repository.create(location);
        Location savedLocation = repository.findById(location.getId());
        return LocationConverter.fromLocation(savedLocation);
    }
}
