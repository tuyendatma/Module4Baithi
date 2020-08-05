package com.codegym.service;

import com.codegym.model.City;

import java.util.List;

public interface ICityService {
    List<City> findAll();

    void save(City city);

    City findOne(Long id);

    void delete(Long id);
}
