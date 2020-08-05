package com.codegym.repository;

import com.codegym.model.City;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICityRepository extends PagingAndSortingRepository<City,Long> {
}
