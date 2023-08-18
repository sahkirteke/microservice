package com.ms.employeeservice.model.DTO;

import com.ms.organizationservice.model.DTO.OrganizationDTO;

public class APIResponseDTO {
    private EmployeeDTO employeeDTO;
    private DepartmentDTO departmentDTO;
    private OrganizationDTO organizationDTO;

    public APIResponseDTO(EmployeeDTO employeeDTO, DepartmentDTO departmentDTO, OrganizationDTO organizationDTO) {
        this.employeeDTO = employeeDTO;
        this.departmentDTO = departmentDTO;
        this.organizationDTO=organizationDTO;
    }


    public APIResponseDTO() {

    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public DepartmentDTO getDepartmentDTO() {
        return departmentDTO;
    }

    public void setDepartmentDTO(DepartmentDTO departmentDTO) {
        this.departmentDTO = departmentDTO;
    }

    public OrganizationDTO getOrganizationDTO() {
        return organizationDTO;
    }

    public void setOrganizationDTO(OrganizationDTO organizationDTO) {
        this.organizationDTO = organizationDTO;
    }
}
