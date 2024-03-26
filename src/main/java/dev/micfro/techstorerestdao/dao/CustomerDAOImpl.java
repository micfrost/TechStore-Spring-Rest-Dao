package dev.micfro.techstorerestdao.dao;

import dev.micfro.techstorerestdao.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAOInterface {

    private final EntityManager entityManager;

    @Autowired
    public CustomerDAOImpl(EntityManager thrEntityManager) {
        this.entityManager = thrEntityManager;
    }

    // CRUD methods

    // CREATE
    @Override
    public Customer saveCustomer(Customer theCustomer) {
        entityManager.persist(theCustomer);
        return theCustomer;
    }

    @Override
    public Customer createCustomer(String customerName)
    {
        Customer customer = new Customer(customerName);
        entityManager.persist(customer);
        return customer;
    }



    // READ
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("from Customer", Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;

    }

    @Override
    public Customer getCustomerById(Long theId) {
        Customer customer = entityManager.find(Customer.class, theId);
        return customer;
    }


    // UPDATE
    @Override
    public Customer updateCustomer(Customer updateCustomer)
    {
      Customer dbcustomer = entityManager.merge(updateCustomer);
        return dbcustomer;
    }

    // DELETE
    @Override
    public String deleteCustomerById(Long theId) {
        Customer customer = entityManager.find(Customer.class, theId);
        entityManager.remove(customer);
return "Customer with id: " + theId + " has been deleted";
    }
}
