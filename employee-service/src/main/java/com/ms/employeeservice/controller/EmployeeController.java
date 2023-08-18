package com.ms.employeeservice.controller;

import com.ms.employeeservice.model.DTO.APIResponseDTO;
import com.ms.employeeservice.model.DTO.EmployeeDTO;
import com.ms.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(
        name = "Employee Service - EmployeeController",
        description = "Employee Controller Exposes REST APIs for Employee-Service"
)
@RestController
@RequestMapping("api/employee")
@CrossOrigin
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(
            summary = "Save Employee REST APIs",
            description = "Save Employee REST APIs is used to employee object in a databases"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 CREATED"
    )
    @PostMapping("/save")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO employeeDTOSaved = employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(employeeDTOSaved, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Employee REST APIs",
            description = "Get Employee REST APIs is used to get a employee object in a databases"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 SUCCESS"
    )
    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDTO> getEmployeeById(@PathVariable("id") Long id){
        APIResponseDTO apiResponseDTO = employeeService.getEmployeeById(id);
        return new ResponseEntity(apiResponseDTO,HttpStatus.OK);
    }
}
