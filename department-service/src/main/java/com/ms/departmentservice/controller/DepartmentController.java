package com.ms.departmentservice.controller;

import com.ms.departmentservice.model.DTO.DepartmentDTO;
import com.ms.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Department Service - DepartmentController",
        description = "Department Controller Exposes REST APIs for Department-Service"
)
@RestController()
@RequestMapping("api/departments")
@CrossOrigin
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Operation(
            summary = "Save Department REST APIs",
            description = "Save Department REST APIs is used to department object in a databases"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 CREATED"
    )
    @PostMapping("/save")
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO departmentDTOSaved =departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(departmentDTOSaved, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Department REST APIs",
            description = "Get Department REST APIs is used to get a department object in a databases"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 SUCCESS"
    )
    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable("department-code") String departmentCode ){
        DepartmentDTO departmentDTO = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDTO,HttpStatus.OK);
    }
}
