package be.ipeters.recap.common.jpa;

import be.ipeters.recap.common.jpa.entity.CityJpaEntity;
import be.ipeters.recap.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityJpaRepository extends JpaRepository<CityJpaEntity, Long> {

}
