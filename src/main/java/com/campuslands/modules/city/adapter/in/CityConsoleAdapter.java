package com.campuslands.modules.city.adapter.in;

import com.campuslands.modules.city.infrastructure.CityRepository;
import com.campuslands.modules.city.domain.City;

public class CityConsoleAdapter {
    private CityRepository cityRepository;

    public CityConsoleAdapter(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void start() {
        
    }
}
