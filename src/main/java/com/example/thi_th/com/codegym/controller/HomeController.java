package com.example.thi_th.com.codegym.controller;

import com.example.thi_th.com.codegym.model.City;
import com.example.thi_th.com.codegym.model.Country;
import com.example.thi_th.com.codegym.service.ICityService;
import com.example.thi_th.com.codegym.service.ICountryService;
import com.example.thi_th.com.codegym.validate.CityValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ICityService cityService;
    @Autowired
    ICountryService countryService;
    @Autowired
    CityValidate cityValidate;

    @ModelAttribute("country")
    private Iterable<Country> countries() {
        return countryService.findAll();
    }
    @GetMapping("/home")
    public ModelAndView home(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("home");
        List<Country> countries = (List<Country>) countryService.findAll();
        Page<City> cityPage = cityService.findAll(pageable);
        modelAndView.addObject("list", cityPage);
        modelAndView.addObject("country", countries);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable int id) {
        City city = cityService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("details");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute City city, BindingResult bindingResult) {
        cityValidate.validate(city, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            return modelAndView;
        }
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        City city = cityService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@Valid @ModelAttribute City city, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("city", city);
            return modelAndView;
        }
        cityService.save(city);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable int id) {
        City city = cityService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute City city) {
        cityService.delete(city.getId());
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        return modelAndView;
    }
    @GetMapping("/findByName")
    public ModelAndView findByName(@PageableDefault(value = 5) Pageable pageable, @RequestParam String findName) {
        ModelAndView modelAndView = new ModelAndView("home");
        Page<City> cityPage = cityService.findAllByName(pageable,findName);
        modelAndView.addObject("list", cityPage);
        return modelAndView;
    }

}
