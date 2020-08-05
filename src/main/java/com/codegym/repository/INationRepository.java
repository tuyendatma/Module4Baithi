package com.codegym.repository;

import com.codegym.model.Nation;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface INationRepository extends PagingAndSortingRepository<Nation,Long> {
}
