package com.budgeting.controller;

import com.budgeting.model.Coa;
import com.budgeting.service.CoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coa")
public class CoaController {

    @Autowired
    private CoaService coaService;

    @GetMapping
    public ResponseEntity<List<Coa>> getAllCoas() {
        List<Coa> coas = coaService.getAllCoas();
        return ResponseEntity.ok(coas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coa> getCoaById(@PathVariable Long id) {
        Coa coa = coaService.getCoaById(id);
        return ResponseEntity.ok(coa);
    }

    @PostMapping
    public ResponseEntity<Coa> createCoa(@RequestBody Coa coa) {
        Coa createdCoa = coaService.createCoa(coa);
        return ResponseEntity.status(201).body(createdCoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coa> updateCoa(@PathVariable Long id, @RequestBody Coa coa) {
        Coa updatedCoa = coaService.updateCoa(id, coa);
        return ResponseEntity.ok(updatedCoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoa(@PathVariable Long id) {
        coaService.deleteCoa(id);
        return ResponseEntity.noContent().build();
    }
}