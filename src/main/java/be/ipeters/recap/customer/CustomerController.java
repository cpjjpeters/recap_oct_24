package be.ipeters.recap.customer;


import be.ipeters.recap.common.exception.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/app-api/customers")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value ={ "/all","/"})
    public List<Customer> findAll() {
        log.debug("findAll");
        return customerService.findAll();
    }

//    // Get Customer by Name
//    @GetMapping("/getCustomerByName/{name}")
//     public Customer getCustomerByName(@PathVariable("name") String name)
//     {
//         log.debug("getCustomerByName");
//         return customerService.getCustomerByName(name);
//     }
    // Get Customer by Id
    @GetMapping("/getCustomer/{id}")
    public Customer getCustomer(@PathVariable("id") Long id)
    {
        log.debug("getCustomer with id {}", id);
        return customerService.getCustomer(id);
    }
    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer) {
        log.debug("createCityCustomer");
        return customerService.save(customer);
    }
    // Add new Customer
    @PostMapping(value = "/addCustomer")
    public String addcustomer(@RequestBody Customer customer)
    {
        log.debug("addCustomer");
        return customerService.addCustomer(customer);
    }

    // Update Customer details
    @PutMapping("/updateCustomer")
    public String
    updateCustomer(@RequestBody Customer customer)
    {
        log.debug("updateCustomer");
        return customerService.updateCustomer(customer);
    }


    @DeleteMapping(value = "/deleteCustomer/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable("id") Long id) {
        log.debug("deleteCustomer {}",id);
        customerService.deleteCustomerById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}