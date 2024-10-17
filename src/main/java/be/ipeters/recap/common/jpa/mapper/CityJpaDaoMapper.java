package be.ipeters.recap.common.jpa.mapper;


import be.ipeters.recap.common.jpa.entity.CityJpaEntity;
import be.ipeters.recap.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author tersc
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CityJpaDaoMapper {
    CityJpaEntity modelToJpaEntity(City city);

    City jpaEntityToModel(CityJpaEntity cityJpaEntity);
}
