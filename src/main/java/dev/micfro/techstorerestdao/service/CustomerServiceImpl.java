package dev.micfro.techstorerestdao.service;

import dev.micfro.techstorerestdao.dao.CustomerDAOInterface;
import dev.micfro.techstorerestdao.model.Customer;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerServiceInterface {

    private final CustomerDAOInterface customerDAOInterface;

    @Autowired
    public CustomerServiceImpl(CustomerDAOInterface theCustomerDAOInterface) {
        this.customerDAOInterface = theCustomerDAOInterface;
    }


    // CRUD

    // CREATE
    @Transactional
    @Override
    public void saveCustomer(Customer theCustomer) {
        customerDAOInterface.saveCustomer(theCustomer);
    }

    @Override
    public Customer createCustomer(String customerName) {
        return customerDAOInterface.createCustomer(customerName);
    }

    // READ
    @Override
    public List<Customer> findAll() {
        return customerDAOInterface.findAll();
    }

    @Override
    public Customer getCustomerById(Long theId) {
        return customerDAOInterface.getCustomerById(theId);
    }


    // UPDATE
    @Transactional
    @Override
    public Customer updateCustomer(Customer theCustomer) {
        return customerDAOInterface.updateCustomer(theCustomer);
    }

    // DELETE
    @Transactional
    @Override
    public String deleteCustomerById(Long theId) {
        customerDAOInterface.deleteCustomerById(theId);
        return "Customer with id: " + theId + " has been deleted";
    }


}
