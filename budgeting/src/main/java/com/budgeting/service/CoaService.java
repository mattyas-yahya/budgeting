package com.budgeting.service;

import com.budgeting.model.Coa;
import com.budgeting.repository.CoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoaService {

    @Autowired
    private CoaRepository coaRepository;

    public List<Coa> getAllCoas() {
        return coaRepository.findAll();
    }

    public Coa getCoaById(Long id) {
        return coaRepository.findById(id).orElse(null);
    }

    public Coa createCoa(Coa coa) {
        return coaRepository.save(coa);
    }

    public Coa updateCoa(Long id, Coa coaDetails) {
        Coa coa = coaRepository.findById(id).orElse(null);
        if (coa != null) {
            coa.setCoaCode(coaDetails.getCoaCode());
            coa.setCoaName(coaDetails.getCoaName());
            coa.setDescription(coaDetails.getDescription());
            return coaRepository.save(coa);
        }
        return null;
    }

    public void deleteCoa(Long id) {
        coaRepository.deleteById(id);
    }
}