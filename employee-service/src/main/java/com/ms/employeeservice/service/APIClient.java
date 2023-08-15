package com.ms.employeeservice.service;

import com.ms.employeeservice.model.DTO.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( name= "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("api/departments/getDepartment/{department-code}")
    DepartmentDTO getDepartment(@PathVariable("department-code") String departmentCode );
}
