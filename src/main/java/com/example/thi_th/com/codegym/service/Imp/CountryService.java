package com.example.thi_th.com.codegym.service.Imp;

import com.example.thi_th.com.codegym.model.Country;
import com.example.thi_th.com.codegym.repository.CountryRepo;
import com.example.thi_th.com.codegym.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService implements ICountryService {
    @Autowired
    CountryRepo countryRepo;

    @Override
    public Iterable<Country> findAll() {
        return countryRepo.findAll();
    }

    @Override
    public Optional<Country> findById(Integer id) {
        return countryRepo.findById(id);
    }

    @Override
    public void save(Country country) {
        countryRepo.save(country);
    }

    @Override
    public void delete(Integer id) {
        countryRepo.deleteById(id);
    }
}
