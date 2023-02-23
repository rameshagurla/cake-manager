package com.waracle.cakemanager.repository;

import com.waracle.cakemanager.entity.CakeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CakeRepository extends JpaRepository<CakeEntity, Long> {
}
