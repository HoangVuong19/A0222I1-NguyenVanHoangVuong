package com.codegym.phone.service.impl;

import com.codegym.phone.model.Phone;
import com.codegym.phone.repository.IPhoneRepository;
import com.codegym.phone.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService implements IPhoneService {
    @Autowired
    private IPhoneRepository phoneRepository;

    @Override
    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Optional<Phone> findById(Long id) {
        return phoneRepository.findById(id);
    }

    @Override
    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public void remove(Long id) {
        phoneRepository.deleteById(id);
    }
}
