package com.codegym.service.impl;

import com.codegym.model.Nation;
import com.codegym.repository.INationRepository;
import com.codegym.service.INationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NationServiceImpl implements INationService {

    @Autowired
    INationRepository nationRepository;

    @Override
    public List<Nation> findAll() {
        List<Nation> list = (List<Nation>) nationRepository.findAll();
        return list;
    }

    @Override
    public Nation findOne(Long id) {
        Nation nation = (nationRepository.findById(id)).get();
        return nation;
    }
}
