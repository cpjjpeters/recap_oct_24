package be.ipeters.recap.common.jpa.order.persistance;

import be.ipeters.recap.common.jpa.order.domain.model.OrderCreation;

import java.util.List;
import java.util.Optional;

public interface OrderCreationPersistenceFacade {
    OrderCreation save(OrderCreation orderCreation);
    List<OrderCreation> findAll();
    Optional<OrderCreation> findById(Long id);
}
