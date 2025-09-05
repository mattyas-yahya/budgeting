package com.budgeting.controller;

import com.budgeting.model.Actual;
import com.budgeting.service.ActualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actual")
public class ActualController {

    @Autowired
    private ActualService actualService;

    @GetMapping
    public ResponseEntity<List<Actual>> getAllActuals() {
        List<Actual> actuals = actualService.findAll();
        return ResponseEntity.ok(actuals);
    }

    @PostMapping
    public ResponseEntity<Actual> createActual(@RequestBody Actual actual) {
        Actual createdActual = actualService.save(actual);
        return ResponseEntity.status(201).body(createdActual);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actual> updateActual(@PathVariable Long id, @RequestBody Actual actual) {
        Actual updatedActual = actualService.update(id, actual);
        return ResponseEntity.ok(updatedActual);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActual(@PathVariable Long id) {
        actualService.delete(id);
        return ResponseEntity.noContent().build();
    }
}