package com.budgeting.repository;

import com.budgeting.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
    // Additional query methods can be defined here if needed
}