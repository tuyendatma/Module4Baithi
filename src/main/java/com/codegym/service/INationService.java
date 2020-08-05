package com.codegym.service;

import com.codegym.model.Nation;

import java.util.List;

public interface INationService {
    List<Nation> findAll();

    Nation findOne(Long id);
}
