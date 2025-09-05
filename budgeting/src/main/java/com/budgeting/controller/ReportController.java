package com.budgeting.controller;

import com.budgeting.model.VarianceReport;
import com.budgeting.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/reports/variance")
    public List<VarianceReport> getVarianceReport(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) String costCenterCode,
            @RequestParam(required = false) String coaCode) {
        return reportService.generateVarianceReport(year, month, costCenterCode, coaCode);
    }
}