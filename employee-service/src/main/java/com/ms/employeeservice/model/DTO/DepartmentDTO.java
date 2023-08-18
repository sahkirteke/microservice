package com.ms.employeeservice.model.DTO;


import io.swagger.v3.oas.annotations.media.Schema;

public class DepartmentDTO {

    private  long id;

    @Schema(
            description = "Department Name"
    )
    private String departmentName;

    @Schema(
            description = "Department Description"
    )
    private String departmentDescription;

    @Schema(
            description = "Department Code"
    )
    private String departmentCode;

    public DepartmentDTO() {
    }

    public DepartmentDTO(long id, String departmentName, String departmentDescription, String departmentCode) {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
        this.departmentCode = departmentCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
}