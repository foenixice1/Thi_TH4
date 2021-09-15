package com.example.thi_th.com.codegym.formatter;

import com.example.thi_th.com.codegym.model.Country;
import com.example.thi_th.com.codegym.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;


public class CountryFormatter implements Formatter<Country> {
    private ICountryService iCountryService;

    @Autowired
    public CountryFormatter(ICountryService countryService) {
        this.iCountryService = countryService;
    }

    @Override
    public Country parse(String text, Locale locale) throws ParseException {
        Optional<Country> branchOptional = iCountryService.findById(Integer.parseInt(text));
        return branchOptional.orElse(null);
    }

    @Override
    public String print(Country object, Locale locale) {
        return "[" + object.getId() + "," + object.getName() + "]";
    }
}