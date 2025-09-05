package com.budgeting.service;

import com.budgeting.model.CostCenter;
import com.budgeting.repository.CostCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostCenterService {

    @Autowired
    private CostCenterRepository costCenterRepository;

    public List<CostCenter> getAllCostCenters() {
        return costCenterRepository.findAll();
    }

    public Optional<CostCenter> getCostCenterById(Long id) {
        return costCenterRepository.findById(id);
    }

    public CostCenter createCostCenter(CostCenter costCenter) {
        return costCenterRepository.save(costCenter);
    }

    public Optional<CostCenter> updateCostCenter(Long id, CostCenter costCenterDetails) {
        return costCenterRepository.findById(id).map(costCenter -> {
            costCenter.setCcCode(costCenterDetails.getCcCode());
            costCenter.setCcName(costCenterDetails.getCcName());
            costCenter.setDescription(costCenterDetails.getDescription());
            return costCenterRepository.save(costCenter);
        });
    }

    public boolean deleteCostCenter(Long id) {
        if (costCenterRepository.existsById(id)) {
            costCenterRepository.deleteById(id);
            return true;
        }
        return false;
    }
}