package com.budgeting.repository;

import com.budgeting.model.Actual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ActualRepository extends JpaRepository<Actual, Long> {
    List<Actual> findByCostCenter_CcIdAndTransactionDateBetween(Long ccId, LocalDate startDate, LocalDate endDate);
}