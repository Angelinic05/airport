package com.campuslands.modules.country.application;


import java.util.List;
import com.campuslands.modules.country.domain.Country;
import com.campuslands.modules.country.infrastructure.CountryRepository;
import java.util.Optional;

public class CountryService {
    
    private CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void createCountry(Country country) {
        countryRepository.save(country);
    }
    public void updateCountry(Country country) {
        countryRepository.update(country);
    }
    public Optional<Country> getCountryById(int id) {
        return countryRepository.findById(id);
    }
    public void deleteCountry(int id) {
        countryRepository.delete(id);
    }
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

}
