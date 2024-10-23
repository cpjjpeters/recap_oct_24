package be.ipeters.recap.common.jpa.order.domain;

import be.ipeters.recap.common.jpa.order.domain.model.OrderCreation;
import be.ipeters.recap.common.jpa.order.persistance.OrderCreationPersistenceFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* carlpeters created on 22/10/2024 inside the package - be.ipeters.recap.common.jpa.order.domain */
@Slf4j
@RequiredArgsConstructor
@Service
public class OrderCreationService {
    private final OrderCreationPersistenceFacade orderCreationPersistenceFacade;

    public OrderCreation save(OrderCreation orderCreation) {
        log.debug("save {}", orderCreation);
        return orderCreationPersistenceFacade.save(orderCreation);
    }

    public Optional<OrderCreation> findById(Long id) {
        log.debug("findById {}", id);
        return orderCreationPersistenceFacade.findById(id);
    }

    public List<OrderCreation> findAll() {
        log.debug("findAll");
        return orderCreationPersistenceFacade.findAll();
    }
}
