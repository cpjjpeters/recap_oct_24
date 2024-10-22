package be.ipeters.recap.common.jpa.order.persistance.jpa.mapper;

import be.ipeters.recap.common.jpa.order.domain.model.OrderCreation;
import be.ipeters.recap.common.jpa.order.persistance.jpa.entity.OrderCreationJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface OrderCreationJpaDaoMapper {
    OrderCreationJpaEntity modelToEntity(OrderCreation orderCreationJ);
    OrderCreation entityToModel(OrderCreationJpaEntity orderCreationJpaEntity);

}
