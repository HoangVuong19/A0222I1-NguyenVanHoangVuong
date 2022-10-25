package com.codegym.book.service.impl;

import com.codegym.book.models.Rent;
import com.codegym.book.repository.IRentRepository;
import com.codegym.book.service.IRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService implements IRentService {
    @Autowired
    IRentRepository rentRepository;

    @Override
    public void save(Rent rent) {
        rentRepository.save(rent);
    }

    @Override
    public List<Rent> findAll() {
        return rentRepository.findAll();
    }

    @Override
    public Rent findById(Integer id) {
        return rentRepository.findAllById(id);
    }

}
