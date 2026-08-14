package com.kristallball.controller;

import com.kristallball.entity.Base;
import com.kristallball.entity.Equipment;
import com.kristallball.entity.EquipmentType;
import com.kristallball.repository.BaseRepository;
import com.kristallball.repository.EquipmentRepository;
import com.kristallball.repository.EquipmentTypeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
@CrossOrigin(origins = {"http://localhost:5173", "https://military-frontend-six.vercel.app"})
public class EquipmentController {

    private final EquipmentRepository equipmentRepository;
    private final BaseRepository baseRepository;
    private final EquipmentTypeRepository equipmentTypeRepository; // 1. Field declared

    // 2. All 3 repositories injected via constructor
    public EquipmentController(
            EquipmentRepository equipmentRepository, 
            BaseRepository baseRepository,
            EquipmentTypeRepository equipmentTypeRepository) {
        this.equipmentRepository = equipmentRepository;
        this.baseRepository = baseRepository;
        this.equipmentTypeRepository = equipmentTypeRepository;
    }

    @GetMapping
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createEquipment(@RequestBody Equipment equipment) {
        // Resolve Base relation
        if (equipment.getBase() != null && equipment.getBase().getId() != null) {
            Base base = baseRepository.findById(equipment.getBase().getId())
                    .orElseThrow(() -> new RuntimeException("Base not found"));
            equipment.setBase(base);
        }

        // Resolve EquipmentType relation safely using equipmentTypeRepository
        if (equipment.getEquipmentType() != null && equipment.getEquipmentType().getId() != null) {
            EquipmentType type = equipmentTypeRepository.findById(equipment.getEquipmentType().getId())
                    .orElse(null); // Assigns null if ID doesn't exist to prevent foreign key crashes
            equipment.setEquipmentType(type);
        }

        Equipment saved = equipmentRepository.save(equipment);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable Long id) {
        equipmentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}