package com.calculator.service;

import java.util.List;

import com.calculator.domain.Pesticide;


public interface PesticideService {
    public List<Pesticide> getAll();

    public Pesticide getById(Long id);

    public void add(Pesticide pesticide);

    public void deletePesticideById(Long id);

    public void deleteAll();

    public void update(Pesticide pesticide);

}
