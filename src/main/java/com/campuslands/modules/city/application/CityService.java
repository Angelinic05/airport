package com.campuslands.modules.city.application;


import java.util.List;
import com.campuslands.modules.city.domain.City;
import com.campuslands.modules.city.infrastructure.CityRepository;
import java.util.Optional;

public class CityService {
    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void createCity(City city) {
        cityRepository.save(city);
    }
    public void updateCity(City city) {
        cityRepository.update(city);
    }
    public Optional<City> getCityById(int id) {
        return cityRepository.findById(id);
    }
    public void deleteCity(int id) {
        cityRepository.delete(id);
    }
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
    
}
