package com.example.thi_th.com.codegym.service;

import com.example.thi_th.com.codegym.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface ICityService extends IGeneralService<City> {
    Page<City> findAll(Pageable pageable);
    Page<City> findAllByName(Pageable pageable, String name);
}
