package dev.micfro.techstorerestdao.rest;

import dev.micfro.techstorerestdao.model.Customer;
import dev.micfro.techstorerestdao.service.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRest {

    private final CustomerServiceInterface customerServiceInterface;

    @Autowired
    public CustomerRest(CustomerServiceInterface theCustomerServiceInterface) {
        this.customerServiceInterface = theCustomerServiceInterface;
    }

    // CRUD

    // READ

    @GetMapping("/customers")
    public List<Customer> findAll() {
        return customerServiceInterface.findAll();
    }


    @GetMapping("/customers/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId) {

        Customer customer = customerServiceInterface.getCustomerById(customerId);
        if (customer == null) {
            throw new RuntimeException("Customer id not found - " + customer);
        }

        return customer;
    }


    // CREATE

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer) {
        customerServiceInterface.saveCustomer(theCustomer);
        return theCustomer;
    }


    // UPDATE

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer) {

        return customerServiceInterface.updateCustomer(theCustomer);
    }


    // DELETE

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomerById(@PathVariable Long customerId) {

        Customer customer = customerServiceInterface.getCustomerById(customerId);

        if (customer == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        }

        customerServiceInterface.deleteCustomerById(customerId);
        return "Customer with id: " + customerId + " has been deleted";
    }


}
