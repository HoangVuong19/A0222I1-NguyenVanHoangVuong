package com.example.exam2.service;

import com.example.exam2.model.Contract;

import java.util.List;
import java.util.Map;

public interface ContractService {
    List<Contract> readAllContracts();

    Map<String, String> addContract(Contract contract);

    Contract findContractById(int id);

    boolean updateContract(Contract contract);

    boolean deleteContractById(int id);

    List<Contract> searchByBookName(String character);
}
