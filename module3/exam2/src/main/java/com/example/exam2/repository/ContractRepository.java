package com.example.exam2.repository;

import com.example.exam2.model.Contract;

import java.util.List;

public interface ContractRepository {
    List<Contract> selectAllContracts();

    void insertContract(Contract contract);

    Contract selectContractById(int id);

    boolean updateContract(Contract contract);

    boolean deleteContractById(int id);

    List<Contract> searchContract(String character);
}
