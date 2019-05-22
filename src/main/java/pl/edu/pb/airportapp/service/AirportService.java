package pl.edu.pb.airportapp.service;

import pl.edu.pb.airportapp.domain.Airport;

import java.util.List;
import java.util.Optional;

public interface AirportService {
    void deleteAirport(Long id);
    void saveOrUpdateAirport(Airport airport);
    List<Airport> listAll();
    Optional<Airport> getAirportById(Long id);
}
