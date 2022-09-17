package com.example.exam3.service.impl;

import com.example.exam3.model.Contract;
import com.example.exam3.repository.ContractRepository;
import com.example.exam3.repository.impl.ContractRepositoryImpl;
import com.example.exam3.service.ContractService;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
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
        List<Contract> list = readAllContracts();
        if (contract.getPlantId().equals("")) {
            map.put("plantId", "plantId is not null");
        } else if (!contract.getPlantId().matches("^[A-Z][A-Z][A-Z]\\d{4}$")) {
            map.put("plantId", "Format is not correct");
        }
        for (Contract l: list){
            if (l.getPlantId().equals(contract.getPlantId())){
                map.put("plantId", "plantId is duplicate");
            }
        }
        if (contract.getArea() == -1) {
            map.put("area", "area is not null");
        } else if (contract.getArea() < 20) {
            map.put("area", "area must not be less than 20");
        }
        if (contract.getPrice() == -1.0) {
            map.put("price", "price is not null");
        } else if (contract.getPrice() < 1000000.0) {
            map.put("price", "price must not be less than 1000000");
        }
        if (contract.getStartDate().toString().equals("2000-12-22")) {
            map.put("startDate", "startDate is not null");
        }
        if (contract.getEndDate().toString().equals("2000-12-22")) {
            map.put("endDate", "endDate is not null");
        } else if (contract.getStartDate().after(contract.getEndDate())) {
            map.put("endDate", "endDate must after startDate");
        } else if (ChronoUnit.MONTHS.between(YearMonth.from(LocalDate.parse(contract.getStartDate().toString())),YearMonth.from(LocalDate.parse(contract.getEndDate().toString()))) < 6) {
            map.put("endDate", "endDate must after startDate 6 month");
        }
        if (map.isEmpty()) {
            contractRepository.insertContract(contract);
        }
        return map;
    }

    @Override
    public boolean deleteContractById(int id) {
        return contractRepository.deleteContractById(id);
    }

    @Override
    public List<Contract> searchByContractType(String type) {
        return contractRepository.searchContractByType(type);
    }
}
