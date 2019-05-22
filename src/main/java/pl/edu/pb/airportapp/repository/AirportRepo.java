package pl.edu.pb.airportapp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pb.airportapp.domain.Airport;

public interface AirportRepo extends CrudRepository<Airport, Long> {

}
