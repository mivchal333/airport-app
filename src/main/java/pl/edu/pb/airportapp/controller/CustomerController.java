package pl.edu.pb.airportapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pb.airportapp.domain.Customer;
import pl.edu.pb.airportapp.service.CustomerService;


import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/customer")
    public String listAllCustomers(Model model) {
        List<Customer> customers = service.listAll();
        model.addAttribute("customers", customers);
        return "customer/customers";
    }

    @GetMapping("/customer/new")
    public String getEmptyForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/customerForm";
    }

    @GetMapping(value = "/customer/edit/{id}")
    public String editCustomer(@PathVariable Long id, Model model) {
        Optional<Customer> customerOpt = service.getCustomerById(id);

        customerOpt.ifPresent(customer -> model.addAttribute("customer", customer));
        return "customer/customerForm";
    }

    @PostMapping("/customer")
    public String saveOrUpdateCustomer(Customer customer) {
        service.saveOrUpdateCustomer(customer);
        return "redirect:/customer/" + customer.getId();
    }

    @RequestMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
        return "redirect:/customer";
    }

    @GetMapping("/customer/{id}")
    public String getCustomer(@PathVariable Long id, Model model) {
        Optional<Customer> customerOpt = service.getCustomerById(id);
        customerOpt.ifPresent(customer -> model.addAttribute("customer", customer));
        return "customer/customer";
    }
}
