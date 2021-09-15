package com.example.thi_th.com.codegym.service.Imp;

import com.example.thi_th.com.codegym.model.City;
import com.example.thi_th.com.codegym.repository.CityRepo;
import com.example.thi_th.com.codegym.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CityService implements ICityService {
    @Autowired
    CityRepo cityRepo;

    @Override
    public Page<City> findAll(Pageable pageable) {
        return cityRepo.findAll(pageable);
    }

    @Override
    public Page<City> findAllByName(Pageable pageable, String name) {
        return cityRepo.findAllByNameContaining(pageable, name);
    }

    @Override
    public Iterable<City> findAll() {
        return cityRepo.findAll();
    }

    @Override
    public Optional<City> findById(Integer id) {
        return cityRepo.findById(id);
    }

    @Override
    public void save(City city) {
        cityRepo.save(city);

    }

    @Override
    public void delete(Integer id) {
        cityRepo.deleteById(id);

    }
}
