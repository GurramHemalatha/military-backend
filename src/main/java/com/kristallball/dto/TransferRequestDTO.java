package com.kristallball.dto;

public class TransferRequestDTO {

    private Long equipmentId;
    private Long fromBaseId;
    private Long toBaseId;
    private Integer quantity;
    private String requestedBy;

    // Default Constructor
    public TransferRequestDTO() {
    }

    // Constructor with fields
    public TransferRequestDTO(Long equipmentId, Long fromBaseId, Long toBaseId, Integer quantity, String requestedBy) {
        this.equipmentId = equipmentId;
        this.fromBaseId = fromBaseId;
        this.toBaseId = toBaseId;
        this.quantity = quantity;
        this.requestedBy = requestedBy;
    }

    // Getters and Setters
    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Long getFromBaseId() {
        return fromBaseId;
    }

    public void setFromBaseId(Long fromBaseId) {
        this.fromBaseId = fromBaseId;
    }

    public Long getToBaseId() {
        return toBaseId;
    }

    public void setToBaseId(Long toBaseId) {
        this.toBaseId = toBaseId;
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
}