package com.budgeting.repository;

import com.budgeting.model.Coa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoaRepository extends JpaRepository<Coa, Long> {
}