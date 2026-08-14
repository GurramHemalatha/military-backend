package com.kristallball.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kristallball.entity.Equipment;


import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    List<Equipment> findByBaseId(Long baseId);
}