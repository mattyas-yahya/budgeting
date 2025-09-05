package com.budgeting.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "budget")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "coa_id", nullable = false)
    private Coa coa;

    @ManyToOne
    @JoinColumn(name = "cc_id", nullable = false)
    private CostCenter costCenter;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int month;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Coa getCoa() { return coa; }
    public void setCoa(Coa coa) { this.coa = coa; }

    public CostCenter getCostCenter() { return costCenter; }
    public void setCostCenter(CostCenter costCenter) { this.costCenter = costCenter; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}