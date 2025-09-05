package com.budgeting.service;

import com.budgeting.model.Actual;
import com.budgeting.repository.ActualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
public class ActualService {

    @Autowired
    private ActualRepository actualRepository;

    public List<Actual> findAll() {
        return actualRepository.findAll();
    }

    public Actual findById(Long id) {
        return actualRepository.findById(id).orElse(null);
    }

    public Actual save(Actual actual) {
        return actualRepository.save(actual);
    }

    public Actual update(Long id, Actual actualDetails) {
        Actual actual = actualRepository.findById(id).orElse(null);
        if (actual != null) {
            actual.setAmount(actualDetails.getAmount());
            actual.setCoa(actualDetails.getCoa());
            actual.setCostCenter(actualDetails.getCostCenter());
            actual.setTransactionDate(actualDetails.getTransactionDate());
            return actualRepository.save(actual);
        }
        return null;
    }

    public void delete(Long id) {
        actualRepository.deleteById(id);
    }

    public List<Actual> findByCostCenterAndPeriod(Long costCenterId, int year, int month) {
        YearMonth ym = YearMonth.of(year, month);
        LocalDate start = ym.atDay(1);
        LocalDate end = ym.atEndOfMonth();
        return actualRepository.findByCostCenter_CcIdAndTransactionDateBetween(costCenterId, start, end);
    }
}