package com.codegym.service.impl;

import com.codegym.model.City;
import com.codegym.repository.ICityRepository;
import com.codegym.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CityServiceImpl implements ICityService {

    @Autowired
    private ICityRepository cityRepository;

    @Override
    public List<City> findAll() {
        List<City> list = (List<City>) cityRepository.findAll();
        return list;
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public City findOne(Long id) {
        City city = (cityRepository.findById(id)).get();
        return city;
    }



    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}
