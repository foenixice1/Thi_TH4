package com.example.thi_th.com.codegym.service;

import java.util.Optional;

public interface IGeneralService<N> {
    Iterable<N> findAll();
    Optional<N> findById(Integer id);
    void save(N n);
    void delete(Integer id);
}
