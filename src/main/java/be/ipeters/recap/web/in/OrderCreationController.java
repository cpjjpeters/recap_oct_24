package be.ipeters.recap.web.in;


import be.ipeters.recap.common.exception.ResourceNotFoundException;
import be.ipeters.recap.common.jpa.order.domain.model.OrderCreation;
import be.ipeters.recap.common.jpa.order.domain.OrderCreationService;
//import be.ipeters.recap.error.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Transactional
@RestController
@RequestMapping(value="/ordercreation", produces = MediaType.APPLICATION_JSON_VALUE)
//@Validated
@Slf4j
public class OrderCreationController {

    private final OrderCreationService orderCreationService;

    public OrderCreationController(OrderCreationService orderCreationService) {
        this.orderCreationService = orderCreationService;
    }

    @PostMapping("/new")
    public OrderCreation createOrderCreation(@RequestBody OrderCreation orderCreation) {
        log.debug("createOrderCreation");
        return orderCreationService.save(orderCreation);
    }

    @GetMapping("/")
    public List<OrderCreation> showOrderCreations() {
        log.debug("getmapping slash ordercreations");
        return orderCreationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderCreation> findOrderCreationById(@PathVariable Long id) {
        log.debug("getmapping slash ordercreations slash id");
         OrderCreation orderCreation = orderCreationService.findById(id)
                 .orElseThrow(()-> new ResourceNotFoundException("OrderCreation with ID: " + id + "not found"));
        return ResponseEntity.ok().body(orderCreation);
    }
}
