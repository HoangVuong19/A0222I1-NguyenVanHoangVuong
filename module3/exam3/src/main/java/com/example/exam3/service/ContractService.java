package com.example.exam3.service;

import com.example.exam3.model.Contract;

import java.util.List;
import java.util.Map;

public interface ContractService {
    List<Contract> readAllContracts();

    Map<String, String> addContract(Contract contract);

    boolean deleteContractById(int id);

    List<Contract> searchByContractType(String type);
}
