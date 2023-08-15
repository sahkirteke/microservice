package com.ms.departmentservice.service;


import com.ms.departmentservice.model.DTO.DepartmentDTO;
import com.ms.departmentservice.model.Department;
import com.ms.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

        Department department = new Department();
        BeanUtils.copyProperties(departmentDTO,department);
        Department departmentSaved = departmentRepository.save(department);
        DepartmentDTO departmentDTOSaved = new DepartmentDTO();
        BeanUtils.copyProperties(departmentSaved,departmentDTOSaved);

        return departmentDTOSaved;

    }

    public DepartmentDTO getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDTO departmentDTO = new DepartmentDTO();
        BeanUtils.copyProperties(department,departmentDTO);
        return departmentDTO;
    }
}
