package ua.goit.jdbc;

import ua.goit.jdbc.config.DatabaseConnectionManager;
import ua.goit.jdbc.dao.Repository;
import ua.goit.jdbc.dao.LocationRepository;
import ua.goit.jdbc.dao.model.LocationDAO;
import ua.goit.jdbc.dto.LocationDTO;
import ua.goit.jdbc.service.LocationService;

public class Main {
    public static void main(String[] args) {
        DatabaseConnectionManager cm = new DatabaseConnectionManager("localhost", "go_it",
                "postgres", "12345");
        LocationDTO dto = new LocationDTO(104, "Khreshatyk", "12345", "Kyiv", "Kyiv");

        Repository<LocationDAO> locationRepository = new LocationRepository(cm);
        LocationService service = new LocationService(locationRepository);

        LocationDTO locationDTO = service.create(dto);
        System.out.println(locationDTO);
//        System.out.println("------------------------------");
//        System.out.println("UPDATED");
//        dto.setCity("Mykolaiv");
//        LocationDTO update = service.update(dto);
//        System.out.println(update);
//
        service.delete(104);
    }
}
