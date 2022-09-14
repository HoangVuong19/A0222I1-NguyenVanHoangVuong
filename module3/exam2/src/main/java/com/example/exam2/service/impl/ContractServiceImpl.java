package com.example.exam2.service.impl;

import com.example.exam2.config.Validation;
import com.example.exam2.model.Contract;
import com.example.exam2.repository.ContractRepository;
import com.example.exam2.repository.impl.ContractRepositoryImpl;
import com.example.exam2.service.ContractService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractServiceImpl implements ContractService {
    ContractRepository contractRepository = new ContractRepositoryImpl();

    @Override
    public List<Contract> readAllContracts() {
        return contractRepository.selectAllContracts();
    }

    @Override
    public Map<String, String> addContract(Contract contract) {
        Map<String, String> map = new HashMap<>();
        if (contract.getDate().equals("")){
            map.put("date", "date is not null");
        } else if(!Validation.checkDate(contract.getDate())){
            map.put("date","Format is not correct");
        }
        if (contract.getRentAmount() == -1){
            map.put("rentAmount", "rentAmount is not null");
        } else if (contract.getRentAmount() < 0){
            map.put("rentAmount", "rentAmount must not have negative value");
        }
        if (map.isEmpty()){
            contractRepository.insertContract(contract);
        }
        return map;
    }

    @Override
    public Contract findContractById(int id) {
        return contractRepository.selectContractById(id);
    }

    @Override
    public boolean updateContract(Contract contract) {
        return contractRepository.updateContract(contract);
    }

    @Override
    public boolean deleteContractById(int id) {
        return contractRepository.deleteContractById(id);
    }

    @Override
    public List<Contract> searchByBookName(String character) {
        return contractRepository.searchContract(character);
    }
}
