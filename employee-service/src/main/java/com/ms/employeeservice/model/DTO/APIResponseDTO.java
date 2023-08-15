package com.ms.employeeservice.model.DTO;

public class APIResponseDTO {
    private EmployeeDTO employeeDTO;
    private DepartmentDTO departmentDTO;

    public APIResponseDTO(EmployeeDTO employeeDTO, DepartmentDTO departmentDTO) {
        this.employeeDTO = employeeDTO;
        this.departmentDTO = departmentDTO;
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
}
