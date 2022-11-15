package com.codegym.phone.service;

import com.codegym.phone.model.Phone;

import java.util.List;
import java.util.Optional;

public interface IPhoneService {
    List<Phone> findAll();

    Optional<Phone> findById(Long id);

    Phone save(Phone phone);

    void remove(Long id);
}
