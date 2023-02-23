package com.waracle.cakemanager.controller;

import com.waracle.cakemanager.entity.CakeEntity;
import com.waracle.cakemanager.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController("/cake")
public class CakeController {

    private CakeService cakeService;

    @Autowired
    public CakeController(final CakeService cakeService) {
        this.cakeService = cakeService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CakeEntity>> list() {
        return ResponseEntity.ok(cakeService.getAllCakeInfo());
    }

    @PostMapping("/addCake")
    public void add(@RequestBody CakeEntity cakeEntity) {
        cakeService.save(cakeEntity);
    }

    @PutMapping("/updateCake/{id}")
    public ResponseEntity<?> update(@RequestBody CakeEntity cakeEntity, @PathVariable Long id) {
        try {
            CakeEntity existCake = cakeService.get(id);
            cakeService.save(cakeEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteCake/{id}")
    public void delete(@PathVariable Long id) {
        cakeService.delete(id);
    }
}
