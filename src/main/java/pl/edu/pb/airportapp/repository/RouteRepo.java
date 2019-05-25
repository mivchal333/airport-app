package pl.edu.pb.airportapp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pb.airportapp.domain.Route;

public interface RouteRepo extends CrudRepository<Route, Long> {

}
