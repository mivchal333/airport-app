package pl.edu.pb.airportapp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pb.airportapp.domain.Airport;
import pl.edu.pb.airportapp.domain.Plane;

public interface PlaneRepo extends CrudRepository<Plane, Long> {

}
