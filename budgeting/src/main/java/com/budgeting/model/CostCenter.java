package com.budgeting.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cost_center")
public class CostCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ccId;

    @Column(name = "cc_code", nullable = false, unique = true)
    private String ccCode;

    @Column(name = "cc_name", nullable = false)
    private String ccName;

    @Column(name = "description")
    private String description;

    // Getters and Setters

    public Long getCcId() {
        return ccId;
    }

    public void setCcId(Long ccId) {
        this.ccId = ccId;
    }

    public String getCcCode() {
        return ccCode;
    }

    public void setCcCode(String ccCode) {
        this.ccCode = ccCode;
    }

    public String getCcName() {
        return ccName;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}