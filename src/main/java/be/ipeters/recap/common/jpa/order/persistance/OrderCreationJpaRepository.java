package be.ipeters.recap.common.jpa.order.persistance;

import be.ipeters.recap.common.jpa.order.persistance.jpa.entity.OrderCreationJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderCreationJpaRepository extends JpaRepository<OrderCreationJpaEntity, Long > {
}
