package pl.edu.pb.airportapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pb.airportapp.domain.Customer;
import pl.edu.pb.airportapp.repository.CustomerRepo;
import pl.edu.pb.airportapp.service.CustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo repo;

    @Override
    public void deleteCustomer(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void saveOrUpdateCustomer(Customer customer) {
        if (customer != null) {
            repo.save(customer);
        }
    }


    @Override
    public List<Customer> listAll() {
        List<Customer> result = new LinkedList<>();
        Iterable<Customer> all = repo.findAll();
        all.forEach(result::add);
        return result;
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return repo.findById(id);

    }
}
