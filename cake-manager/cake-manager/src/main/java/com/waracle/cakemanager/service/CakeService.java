package com.waracle.cakemanager.service;

import com.waracle.cakemanager.entity.CakeEntity;
import com.waracle.cakemanager.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CakeService {

    private CakeRepository cakeRepository;

    @Autowired
    public CakeService(final CakeRepository cakeRepository) {
        this.cakeRepository = cakeRepository;
    }

    public List<CakeEntity> getAllCakeInfo() {
        return this.cakeRepository.findAll();
    }

    public CakeEntity get(final Long id) {
        Optional<CakeEntity> cakeEntity = cakeRepository.findById(id);
        if (cakeEntity.isPresent()) {
            return cakeEntity.get();
        }
        return (CakeEntity) Collections.emptyList();
    }

    public void delete(final Long id) {
        cakeRepository.deleteById(id);
    }

    public void save(final CakeEntity cakeEntity) {
        cakeRepository.save(cakeEntity);
    }
}
