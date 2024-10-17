package be.ipeters.recap.persistence;



import be.ipeters.recap.model.City;

import java.util.List;

public interface CityPersistenceFacade {

    City save(City city);

    List<City> findAll();

    City findById(Long id);

    void delete(City city);


    void deleteById(Long id);

    City update(City city);
}
