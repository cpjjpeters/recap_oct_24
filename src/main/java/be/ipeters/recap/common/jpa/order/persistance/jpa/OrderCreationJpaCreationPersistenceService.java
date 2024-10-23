package be.ipeters.recap.common.jpa.order.persistance.jpa;

import be.ipeters.recap.common.jpa.order.domain.model.OrderCreation;
import be.ipeters.recap.common.jpa.order.persistance.OrderCreationJpaRepository;
import be.ipeters.recap.common.jpa.order.persistance.OrderCreationPersistenceFacade;
import be.ipeters.recap.common.jpa.order.persistance.jpa.entity.OrderCreationJpaEntity;
import be.ipeters.recap.common.jpa.order.persistance.jpa.mapper.OrderCreationJpaDaoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* carlpeters created on 22/10/2024 inside the package - be.ipeters.recap.common.jpa.order.persistance.jpa */
@Slf4j
@Service
public class OrderCreationJpaCreationPersistenceService implements OrderCreationPersistenceFacade {
    private final OrderCreationJpaDaoMapper orderCreationJpaDaoMapper;
    private final OrderCreationJpaRepository orderCreationJpaRepository;

    public OrderCreationJpaCreationPersistenceService(OrderCreationJpaDaoMapper orderCreationJpaDaoMapper, OrderCreationJpaRepository orderCreationJpaRepository) {
        this.orderCreationJpaDaoMapper = orderCreationJpaDaoMapper;
        this.orderCreationJpaRepository = orderCreationJpaRepository;
    }


    @Override
    public OrderCreation save(OrderCreation orderCreation) {
        final OrderCreationJpaEntity orderCreationJpaEntity = orderCreationJpaDaoMapper.modelToEntity(orderCreation);
        log.debug("Saving orderCreation {} into orderCreationJpaEntity: {}", orderCreation, orderCreationJpaEntity);
        final OrderCreationJpaEntity savedOrderCreationJpaEntity = orderCreationJpaRepository.save(orderCreationJpaEntity);
        this.orderCreationJpaRepository.flush();
        return this.orderCreationJpaDaoMapper.entityToModel(savedOrderCreationJpaEntity);
//        Optional<OrderCreation> orderCreationOptional = this.orderCreationJpaRepository.findById(savedOrderCreationJpaEntity.getId());
    }

    @Override
    public List<OrderCreation> findAll() {
        return this.orderCreationJpaRepository.findAll()
                .stream()
                .map(this.orderCreationJpaDaoMapper::entityToModel)
                .toList();
    }

    @Override
    public Optional<OrderCreation> findById(Long id) {
        return this.orderCreationJpaRepository.findById(id)
                .map(this.orderCreationJpaDaoMapper:: entityToModel);
    }
}
