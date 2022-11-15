package com.codegym.phone.controller;

import com.codegym.phone.model.Phone;
import com.codegym.phone.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/phone")
@CrossOrigin
public class PhoneApiController {
    @Autowired
    private IPhoneService phoneService;

    @GetMapping("/list")
    public ResponseEntity<List<Phone>> allPhones() {
        return new ResponseEntity<>(phoneService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Phone> createPhone(@RequestBody Phone phone) {
        return new ResponseEntity<>(phoneService.save(phone), HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Phone> editPhone(@RequestBody Phone phone) {
        return new ResponseEntity<>(phoneService.save(phone), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Phone> deletePhone(@PathVariable Long id) {
        Optional<Phone> phoneOptional = phoneService.findById(id);
        if (!phoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        phoneService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
