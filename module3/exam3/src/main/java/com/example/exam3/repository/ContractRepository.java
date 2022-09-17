package com.example.exam3.repository;

import com.example.exam3.model.Contract;

import java.util.List;

public interface ContractRepository {
    List<Contract> selectAllContracts();

    void insertContract(Contract contract);

    boolean deleteContractById(int id);

    List<Contract> searchContractByType(String type);
}
