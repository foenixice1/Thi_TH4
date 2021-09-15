package com.example.thi_th.com.codegym.repository;

import com.example.thi_th.com.codegym.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepo extends PagingAndSortingRepository<City,Integer> {
    Page<City> findAllByNameContaining(Pageable pageable , String name);
}
