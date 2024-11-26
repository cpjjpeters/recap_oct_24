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

    // Method to get customer by Id.Throws
//    public City getCity(Long id)
//    {
//        return cityPersistenceFacade.findById(id);
//    }

    // Method to add new customer details to database.Throws
    // CityAlreadyExistsException when customer detail
    // already exist
//    public String addCity(City customer)
//    {
//        City existingCity
//                = cityPersistenceFacade.findById(customer.getId())
//                .orElse(null);
//        if (existingCity == null) {
//            cityPersistenceFacade.save(customer);
//            return "City added successfully";
//        }
//        else
//            throw new CityAlreadyExistsException(
//                    "City already exists!!");
//    }

    // Method to update customer details to database.Throws
    // NoSuchCityExistsException when customer doesn't
    // already exist in database
//    public String updateCity(City customer)
//    {
//        City existingCity
//                = cityPersistenceFacade.findById(customer.getId())
//                .orElse(null);
//        if (existingCity == null)
//            throw new NoSuchCityExistsException(
//                    "No Such City exists!!");
//        else {
//            existingCity.setName(customer.getName());
//            existingCity.setAddress(
//                    customer.getAddress());
//            cityPersistenceFacade.save(existingCity);
//            return "Record updated Successfully";
//        }
//    }
    
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
