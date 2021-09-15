package com.example.thi_th.com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.Set;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Pattern(regexp = "^[^\\d]+$", message = "Name only letters can't enter numbers")
    String name;


    @NotBlank
    @Positive(message = "số nguyên dương từ 0 trở đi")
    String area;
    @NotBlank
    @Positive(message = "số nguyên dương từ 0 trở đi")
    String population;
    @NotBlank
    @Positive(message = "số nguyên dương từ 0 trở đi")
    String gdp;
    @NotBlank
    String introduce;
    @ManyToOne
    private Country country;

    public City() {
    }

    public City(Integer id, String name, String area, String population, String gdp, String introduce, Country country) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.introduce = introduce;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getGdp() {
        return gdp;
    }

    public void setGdp(String gdp) {
        this.gdp = gdp;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
