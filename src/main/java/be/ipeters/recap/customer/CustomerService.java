package be.ipeters.recap.customer;

import java.util.List;

public interface CustomerService {

    // Method to get customer by its Id
    Customer getCustomer(Long id);

    // Method to add a new Customer
    // into the database
    String addCustomer(Customer customer);

    // Method to update details of a Customer
    String updateCustomer(Customer customer);

    List<Customer> findAll();

    Customer save(Customer customer);

    String deleteCustomer(Long id);
    Customer findCustomerById(Long id);
    List<Customer> findCustomersByName(String name);
    void delete(Customer customer);
    void deleteCustomerById(Long id);
}