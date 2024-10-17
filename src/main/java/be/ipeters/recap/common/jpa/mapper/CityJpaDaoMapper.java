package be.ipeters.recap.common.jpa.mapper;


import be.ipeters.recap.common.jpa.entity.CityJpaEntity;
import be.ipeters.recap.model.City;
//import org.mapstruct.Mapper;
//import org.mapstruct.ReportingPolicy;
import  fr.xebia.extras.selma.Mapper;
/**
 * @author tersc
 */
@Mapper
public interface CityJpaDaoMapper {
    CityJpaEntity modelToJpaEntity(City city);

    City jpaEntityToModel(CityJpaEntity cityJpaEntity);
}
