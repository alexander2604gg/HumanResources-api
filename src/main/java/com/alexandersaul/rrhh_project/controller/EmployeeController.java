package com.alexandersaul.rrhh_project.controller;

import com.alexandersaul.rrhh_project.constants.EmployeeConstants;
import com.alexandersaul.rrhh_project.dto.employee.EmployeeRegisterDto;
import com.alexandersaul.rrhh_project.dto.employee.EmployeeResponseDto;
import com.alexandersaul.rrhh_project.dto.response.ResponseDto;
import com.alexandersaul.rrhh_project.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/paginated")
    public ResponseEntity<Page<EmployeeResponseDto>> getEmployeesPaginated(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size) {

        Page<EmployeeResponseDto> employeePage = employeeService.getEmployeesPaginated(page, size);

        return ResponseEntity.ok()
                .body(employeePage);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> registerEmployee(@RequestBody EmployeeRegisterDto employeeRegisterDto) {
        employeeService.registerEmployee(employeeRegisterDto);
        return ResponseEntity.ok()
                .body(new ResponseDto(EmployeeConstants.STATUS_201 , EmployeeConstants.MESSAGE_201));
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
