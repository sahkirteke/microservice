package com.ms.employeeservice.controller;

import com.ms.employeeservice.model.DTO.APIResponseDTO;
import com.ms.employeeservice.model.DTO.EmployeeDTO;
import com.ms.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employee")
@CrossOrigin
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO employeeDTOSaved = employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(employeeDTOSaved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDTO> getEmployeeById(@PathVariable("id") Long id){
        APIResponseDTO apiResponseDTO = employeeService.getEmployeeById(id);
        return new ResponseEntity(apiResponseDTO,HttpStatus.OK);
    }
}
