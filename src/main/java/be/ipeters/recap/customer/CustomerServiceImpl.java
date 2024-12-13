package be.ipeters.recap.customer;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl
        implements CustomerService {

    @Autowired
    private CustomerRepository customerRespository;

    // Method to get customer by Id.Throws
    // NoSuchElementException for invalid Id
    public Customer getCustomer(Long id)
    {
        return customerRespository.findById(id).orElseThrow(
                ()
//                        -> new NoSuchElementException(
                                -> new NoSuchCustomerExistsException(
                        "NO CUSTOMER PRESENT WITH ID = " + id));
    }

    // Method to add new customer details to database.Throws
    // CustomerAlreadyExistsException when customer detail
    // already exist
    public String addCustomer(Customer customer)
    {
        Customer existingCustomer
                = customerRespository.findById(customer.getId())
                .orElse(null);
        if (existingCustomer == null) {
            customerRespository.save(customer);
            return "Customer added successfully";
        }
        else
            throw new CustomerAlreadyExistsException(
                    "Customer already exists!!");
    }

    @Override
    public Customer save(Customer customer) {
        final Customer savedCustomer = this.customerRespository.save(customer);
        return savedCustomer;
    }

    @Override
    public String deleteCustomer(Long id) {
        Customer existingCustomer
                = customerRespository.findById(id)
                .orElse(null);
        if (existingCustomer == null)
            throw new NoSuchCustomerExistsException(
                    "No Such Customer exists!!");
        else {
            customerRespository.deleteById(id);
            return "Record deleted Successfully";
        }
    }

    @Override
    public Customer findCustomerById(Long id) {
        Customer customer = customerRespository.findById(id)
               .orElse(null);
        if (customer == null)
            throw new NoSuchCustomerExistsException(
                    "No Such Customer exists!!");
        else
            return customer;
    }

    @Override
    public List<Customer> findCustomersByName(String name) {
        return List.of();
    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public void deleteCustomerById(Long id) {
        Customer existingCustomer
                 = customerRespository.findById(id)
                 .orElse(null);
        if (existingCustomer == null)
            throw new NoSuchCustomerExistsException(
                     "No Such Customer exists!!");
        else
            customerRespository.deleteById(id);

    }

    // Method to update customer details to database.Throws
    // NoSuchCustomerExistsException when customer doesn't
    // already exist in database
    public Customer updateCustomer(Customer customer)
    {
        Customer existingCustomer
                = customerRespository.findById(customer.getId())
                .orElse(null);
        if (existingCustomer == null)
            throw new NoSuchCustomerExistsException(
                    "No Such Customer exists!!");
        else {
            existingCustomer.setName(customer.getName());
            existingCustomer.setAddress(
                    customer.getAddress());
            return customerRespository.save(existingCustomer);
//             "Record updated Successfully";
        }
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRespository.findAll();
    }

}
