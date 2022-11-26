package com.example.demo.service;

import com.example.demo.model.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();

    //Page<Contract> paging(String name, Pageable pageable);

    Contract save(Contract contract);

    Contract findById(Long id);

//    void remove(Long id);
}
