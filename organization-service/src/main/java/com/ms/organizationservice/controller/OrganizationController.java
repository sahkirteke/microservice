package com.ms.organizationservice.controller;

import com.ms.organizationservice.model.DTO.OrganizationDTO;
import com.ms.organizationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Organization Service - OrganizationController",
        description = "Organization Controller Exposes REST APIs for Organization-Service"
)
@RestController
@RequestMapping("api/organizations")
public class OrganizationController {

    private OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    // Build Save Organization REST API
    @Operation(
            summary = "Save Organization REST APIs",
            description = "Save Organization REST APIs is used to organization object in a databases"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDTO> saveOrganization(@RequestBody OrganizationDTO organizationDto){
        OrganizationDTO savedOrganization = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    // Build Get Organization by Code REST API
    @Operation(
            summary = "Get Organization REST APIs",
            description = "Get Organization REST APIs is used to get a organization object in a databases"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 SUCCESS"
    )
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDTO> getOrganization(@PathVariable("code") String organizationCode){
        OrganizationDTO organizationDto = organizationService.getOrganizationByCode(organizationCode);
        return ResponseEntity.ok(organizationDto);
    }

}