package ua.goit.jdbc.service;

import ua.goit.jdbc.dao.Repository;
import ua.goit.jdbc.dao.model.LocationDAO;
import ua.goit.jdbc.dto.LocationDTO;

public class LocationService {

    private Repository<LocationDAO> repository;

    public LocationService(Repository<LocationDAO> repository) {
        this.repository = repository;
    }

    public LocationDTO create(LocationDTO locationDTO) {
        LocationDAO locationDAO = LocationConverter.toLocation(locationDTO);
        repository.create(locationDAO);
        LocationDAO savedLocationDAO = repository.findById(locationDAO.getId());
        return LocationConverter.fromLocation(savedLocationDAO);
    }

    public LocationDTO update(LocationDTO dto) {
        LocationDAO locationDAO = LocationConverter.toLocation(dto);
        repository.update(locationDAO);
        LocationDAO updatedLocationDAO = repository.findById(dto.getId());
        return LocationConverter.fromLocation(updatedLocationDAO);
    }

    public void delete(int id) {
        repository.delete(id);
    }
}
