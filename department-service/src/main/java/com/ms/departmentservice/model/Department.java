package com.ms.departmentservice.model;

import jakarta.persistence.*;

@Entity
@Table(name ="departments" )
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;


    private String departmentName;
    private String departmentDescription;
    private String departmentCode;

    public Department() {
    }

    public Department(long id, String departmentName, String departmentDescription, String departmentCode) {
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
