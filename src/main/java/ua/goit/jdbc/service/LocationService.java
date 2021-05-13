package ua.goit.jdbc.service;

import ua.goit.jdbc.dao.Repository;
import ua.goit.jdbc.dao.model.Location;
import ua.goit.jdbc.dto.LocationDTO;

public class LocationService {

    private Repository<Location> repository;

    public LocationService(Repository<Location> repository) {
        this.repository = repository;
    }

    public LocationDTO create(LocationDTO locationDTO) {
        Location location = LocationConverter.toLocation(locationDTO);
        //find departament and validate
        repository.create(location);
        Location savedLocation = repository.findById(location.getId());
        return LocationConverter.fromLocation(savedLocation);
    }
}
