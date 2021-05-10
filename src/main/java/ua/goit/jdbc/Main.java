package ua.goit.jdbc;

import ua.goit.jdbc.config.DatabaseConnectionManager;
import ua.goit.jdbc.dao.DataAccessObject;
import ua.goit.jdbc.dao.LocationDAO;
import ua.goit.jdbc.dao.model.Location;
import ua.goit.jdbc.dto.LocationDTO;
import ua.goit.jdbc.service.LocationService;

public class Main {
    public static void main(String[] args) {
        DatabaseConnectionManager cm = new DatabaseConnectionManager("localhost", "go_it",
                "postgres", "12345");
        LocationDTO dto = new LocationDTO(100, "Ukraine", "12345", "Kyiv", "Kyiv");

        DataAccessObject<Location> locationRepository = new LocationDAO(cm);
        LocationService service = new LocationService(locationRepository);

        LocationDTO locationDTO = service.create(dto);

        System.out.println(locationDTO);
    }
}
