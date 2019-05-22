package pl.edu.pb.airportapp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pb.airportapp.domain.Customer;
import pl.edu.pb.airportapp.domain.Plane;

public interface CustomerRepo extends CrudRepository<Customer, Long> {

}
