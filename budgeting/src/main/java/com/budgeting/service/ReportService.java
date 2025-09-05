package com.budgeting.service;

import com.budgeting.model.VarianceReport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {
    public List<VarianceReport> generateVarianceReport(Integer year, Integer month, String costCenterCode, String coaCode) {
        // Dummy implementation, replace with real logic
        return new ArrayList<>();
    }
}
