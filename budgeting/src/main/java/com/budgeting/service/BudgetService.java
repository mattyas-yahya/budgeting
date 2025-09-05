package com.budgeting.service;

import com.budgeting.model.Budget;
import com.budgeting.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public List<Budget> findAll() {
        return budgetRepository.findAll();
    }

    public Budget findById(Long id) {
        return budgetRepository.findById(id).orElse(null);
    }

    public Budget save(Budget budget) {
        return budgetRepository.save(budget);
    }

    public Budget update(Long id, Budget budgetDetails) {
        Budget budget = budgetRepository.findById(id).orElse(null);
        if (budget != null) {
            budget.setAmount(budgetDetails.getAmount());
            budget.setCoa(budgetDetails.getCoa());
            budget.setCostCenter(budgetDetails.getCostCenter());
            budget.setYear(budgetDetails.getYear());
            budget.setMonth(budgetDetails.getMonth());
            return budgetRepository.save(budget);
        }
        return null;
    }

    public void delete(Long id) {
        budgetRepository.deleteById(id);
    }
}