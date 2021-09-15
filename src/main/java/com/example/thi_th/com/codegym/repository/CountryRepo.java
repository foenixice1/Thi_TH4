package com.example.thi_th.com.codegym.repository;


import com.example.thi_th.com.codegym.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepo extends PagingAndSortingRepository<Country, Integer> {
}
