package be.ipeters.recap.customer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/app-api/customers")
@RestController
public class CustomerRestController {

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
    public Customer getCustomerById(@PathVariable("id") Long id)
    {
        log.debug("get Customer with id {}", id);
        return customerService.getCustomer(id);
    }
    // Get Customer by Id
    @GetMapping("/findCustomer/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable("id") Long id)
    {
        log.debug("find Customer with id {}", id);
        return ResponseEntity.ok().body( customerService.getCustomer(id));
    }
    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        log.debug("createCityCustomer");
        return ResponseEntity.ok().body(customerService.save(customer));
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
    public ResponseEntity<Customer>     updateCustomer(@RequestBody Customer customer)
    {
        log.debug("updateCustomer");
        return ResponseEntity.ok().body(customerService.updateCustomer(customer));
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