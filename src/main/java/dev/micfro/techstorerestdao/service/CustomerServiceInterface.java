package dev.micfro.techstorerestdao.service;

import dev.micfro.techstorerestdao.model.Customer;

import java.util.List;

public interface CustomerServiceInterface {

    // CRUD

    // CRUD

    // CREATE
    public void saveCustomer(Customer theCustomer);

    public Customer createCustomer(String customerName);

    // READ
    public List<Customer> findAll();

    public Customer getCustomerById(Long theId);




    // UPDATE
    public Customer updateCustomer(Customer theCustomer);


    // DELETE
    public String deleteCustomerById(Long theId);

}
