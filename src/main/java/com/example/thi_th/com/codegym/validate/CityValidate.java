package com.example.thi_th.com.codegym.validate;

import com.example.thi_th.com.codegym.model.City;
import com.example.thi_th.com.codegym.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class CityValidate implements Validator {
    @Autowired
    ICityService cityService;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Iterable<City> list = cityService.findAll();
        City city = (City) target;
        for (City s : list) {
            if(s.getName().equals(city.getName())) {
                errors.rejectValue("name" , "name.duplicate" , "City code already exists !");
                break;
            }
        }
    }
}
