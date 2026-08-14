package com.kristallball.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transfers")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipment_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Equipment equipment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipment_type_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private EquipmentType equipmentType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_base_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Base fromBase;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_base_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Base toBase;

    private Integer quantity;
    private String requestedBy;
    private String status;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Transfer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Base getFromBase() {
        return fromBase;
    }

    public void setFromBase(Base fromBase) {
        this.fromBase = fromBase;
    }

    public Base getToBase() {
        return toBase;
    }

    public void setToBase(Base toBase) {
        this.toBase = toBase;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}