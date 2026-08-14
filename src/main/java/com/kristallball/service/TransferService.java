package com.kristallball.service;

import com.kristallball.dto.TransferRequestDTO;
import com.kristallball.entity.Base;
import com.kristallball.entity.Equipment;
import com.kristallball.entity.Transfer;
import com.kristallball.repository.BaseRepository;
import com.kristallball.repository.EquipmentRepository;
import com.kristallball.repository.TransferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {

    private final TransferRepository transferRepository;
    private final EquipmentRepository equipmentRepository;
    private final BaseRepository baseRepository;

    public TransferService(TransferRepository transferRepository,
                           EquipmentRepository equipmentRepository,
                           BaseRepository baseRepository) {
        this.transferRepository = transferRepository;
        this.equipmentRepository = equipmentRepository;
        this.baseRepository = baseRepository;
    }

    public Transfer createTransfer(TransferRequestDTO requestDTO) {
        Equipment equipment = equipmentRepository.findById(requestDTO.getEquipmentId())
                .orElseThrow(() -> new RuntimeException("Equipment not found"));
        
        Base fromBase = baseRepository.findById(requestDTO.getFromBaseId())
                .orElseThrow(() -> new RuntimeException("From Base not found"));
        
        Base toBase = baseRepository.findById(requestDTO.getToBaseId())
                .orElseThrow(() -> new RuntimeException("To Base not found"));

        Transfer transfer = new Transfer();
        transfer.setEquipment(equipment);
        transfer.setFromBase(fromBase);
        transfer.setToBase(toBase);
        transfer.setQuantity(requestDTO.getQuantity());
        transfer.setRequestedBy(requestDTO.getRequestedBy());
        transfer.setStatus("PENDING");

        return transferRepository.save(transfer);
    }

    public List<Transfer> getAllTransfers() {
        return transferRepository.findAll();
    }

    public void deleteTransfer(Long id) {
        transferRepository.deleteById(id);
    }
}