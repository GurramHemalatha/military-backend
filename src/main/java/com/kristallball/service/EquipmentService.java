package com.kristallball.service;

import com.kristallball.entity.Equipment;
import com.kristallball.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    public Equipment saveEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(id);
    }
}