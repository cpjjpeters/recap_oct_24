package be.ipeters.recap.service;

import be.ipeters.recap.common.exception.NoSuchCityExistsException;
import be.ipeters.recap.common.jpa.CityJpaRepository;
import be.ipeters.recap.common.jpa.entity.CityJpaEntity;
import be.ipeters.recap.common.jpa.mapper.CityJpaDaoMapper;
import be.ipeters.recap.model.City;
import be.ipeters.recap.persistence.CityPersistenceFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CityJpaPersistenceService implements CityPersistenceFacade {

    private final CityJpaRepository cityJpaRepository;
    private final CityJpaDaoMapper cityJpaDaoMapper;


    public CityJpaPersistenceService(CityJpaRepository cityJpaRepository, CityJpaDaoMapper cityJpaDaoMapper) {
        this.cityJpaRepository = cityJpaRepository;
        this.cityJpaDaoMapper = cityJpaDaoMapper;
    }

    @Override
    public City save(City city) {
        final CityJpaEntity cityJpaEntity = this.cityJpaRepository.save(cityJpaDaoMapper.modelToJpaEntity(city));
        log.debug("City JPA = {}", cityJpaEntity.getName());
        return this.cityJpaDaoMapper.jpaEntityToModel(cityJpaEntity);
    }

    public List<City> findAll() {
        return this.cityJpaRepository.findAll()
                .stream()
                .map(this.cityJpaDaoMapper::jpaEntityToModel).collect(Collectors.toList());
    }

    public City findById(Long id) {
        return this.cityJpaRepository.findById(id)
                .map(this.cityJpaDaoMapper::jpaEntityToModel)
                .orElseThrow(()
                        -> new NoSuchElementException(
//                        -> new NoSuchCityExistsException(
                                "NO CITY PRESENT WITH ID = " +id))
//                .orElseThrow(()-> new ResourceNotFoundException("City not found for this id ::" + id))
                ;
    }

    public void deleteAll() {
        this.cityJpaRepository.deleteAll();
    }

    public void delete(City city) {
        this.cityJpaRepository.delete(this.cityJpaDaoMapper.modelToJpaEntity(city));
    }

    @Override
    public void deleteById(Long id) {
        this.cityJpaRepository.deleteById(id);
    }

    @Override
    public City update(City city) {
        return this.cityJpaDaoMapper.jpaEntityToModel(this.cityJpaRepository.save(this.cityJpaDaoMapper.modelToJpaEntity(city)));
    }

    @Override
    public City findByCityId(long theId) {
        return this.cityJpaDaoMapper.jpaEntityToModel(this.cityJpaRepository.findById(theId).orElse(null));
    }

}
