package be.ipeters.recap.service;


import be.ipeters.recap.common.exception.NoSuchCityExistsException;
import be.ipeters.recap.common.exception.ResourceNotFoundException;
import be.ipeters.recap.model.City;
import be.ipeters.recap.persistence.CityPersistenceFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CityService {

    private CityPersistenceFacade cityPersistenceFacade ;

    public CityService(CityPersistenceFacade cityPersistenceFacade) {
        this.cityPersistenceFacade = cityPersistenceFacade;
    }

    public List<City> findAll() {
        return this.cityPersistenceFacade.findAll();
    }

    public City findById(Long id) {
        City city = this.cityPersistenceFacade.findById(id);
//        if(city== null){
//            throw new NoSuchCityExistsException("City with id " + id + " not found");
//        }
        return city;
    }

    
    public City save(City city) {
        return this.cityPersistenceFacade.save(city);
    }

    public City update(City city) {
        return this.cityPersistenceFacade.save(city);
    }

    public void deleteById(Long id) {
        this.cityPersistenceFacade.deleteById(id);
    }

    public void delete(City city){
        this.cityPersistenceFacade.delete(city);

    }

    public City findByCityId(long theId) {
        return this.cityPersistenceFacade.findByCityId(theId);
    }
}
