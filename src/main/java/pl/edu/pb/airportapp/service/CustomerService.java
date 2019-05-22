package pl.edu.pb.airportapp.service;

import pl.edu.pb.airportapp.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    void deleteCustomer(Long id);
    void saveOrUpdateCustomer(Customer airport);
    List<Customer> listAll();
    Optional<Customer> getCustomerById(Long id);
}
