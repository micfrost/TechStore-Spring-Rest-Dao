package dev.micfro.techstorerestdao.dao;

import dev.micfro.techstorerestdao.model.Customer;

import java.util.List;

public interface CustomerDAOInterface {

    // CRUD

    // CREATE
    public Customer saveCustomer(Customer theCustomer);


    public Customer createCustomer(String customerName);

    // READ
    public List<Customer> findAll();

    public Customer getCustomerById(Long theId);



    // UPDATE
    public Customer updateCustomer(Customer theCustomer);


    // DELETE
    public String deleteCustomerById(Long theId);


}
