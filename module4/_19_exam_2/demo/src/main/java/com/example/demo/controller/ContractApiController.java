package com.example.demo.controller;

import com.example.demo.model.Contract;
import com.example.demo.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ContractApiController {

    @Autowired
    private IContractService contractService;

    @PostMapping("/create")
    public ResponseEntity<Contract> saveContract(@Valid @RequestBody Contract contract){
        return new ResponseEntity<>(contractService.save(contract), HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Contract> editContract(@Valid @RequestBody Contract contract){
        return new ResponseEntity<>(contractService.save(contract), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
