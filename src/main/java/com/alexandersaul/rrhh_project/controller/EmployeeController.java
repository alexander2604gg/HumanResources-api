package com.alexandersaul.rrhh_project.controller;

import com.alexandersaul.rrhh_project.dto.employee.EmployeeRegisterDto;
import com.alexandersaul.rrhh_project.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Void> getAllEmployees() {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<String> registerEmployee(@RequestBody EmployeeRegisterDto employeeRegisterDto) {
        employeeService.registerEmployee(employeeRegisterDto);
        return ResponseEntity.ok()
                .body("Employee created");
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
