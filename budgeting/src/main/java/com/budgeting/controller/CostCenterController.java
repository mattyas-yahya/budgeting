package com.budgeting.controller;

import com.budgeting.model.CostCenter;
import com.budgeting.service.CostCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cost-centers")
public class CostCenterController {

    @Autowired
    private CostCenterService costCenterService;

    @GetMapping
    public List<CostCenter> getAllCostCenters() {
        return costCenterService.getAllCostCenters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostCenter> getCostCenterById(@PathVariable Long id) {
        return costCenterService.getCostCenterById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CostCenter createCostCenter(@RequestBody CostCenter costCenter) {
        return costCenterService.createCostCenter(costCenter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CostCenter> updateCostCenter(@PathVariable Long id, @RequestBody CostCenter costCenter) {
        return costCenterService.updateCostCenter(id, costCenter)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCostCenter(@PathVariable Long id) {
        if (costCenterService.deleteCostCenter(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}