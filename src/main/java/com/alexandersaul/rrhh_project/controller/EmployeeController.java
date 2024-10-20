package com.alexandersaul.rrhh_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public ResponseEntity<Void> getAllEmployees() {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> registerEmployee() {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployee() {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee() {
        return ResponseEntity.ok().build();
    }

}
