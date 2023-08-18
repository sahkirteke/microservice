package com.ms.employeeservice.service;

import com.ms.employeeservice.model.DTO.APIResponseDTO;
import com.ms.employeeservice.model.DTO.DepartmentDTO;
import com.ms.employeeservice.model.DTO.EmployeeDTO;
import com.ms.employeeservice.model.Employee;
import com.ms.employeeservice.repository.EmployeeRepository;
import com.ms.organizationservice.model.DTO.OrganizationDTO;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    private EmployeeRepository employeeRepository;

    private APIClient apiClient;

//    private RestTemplate restTemplate;
          private WebClient webClient;




    public EmployeeService(EmployeeRepository employeeRepository,
                           APIClient apiClient,
                           WebClient webClient) {
        this.employeeRepository = employeeRepository;
        this.apiClient=apiClient;
        this.webClient=webClient;
    }

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO){

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        Employee employeeSaved= employeeRepository.save(employee);
        EmployeeDTO employeeDTOSaved = new EmployeeDTO();
        BeanUtils.copyProperties(employeeSaved,employeeDTOSaved);
        return employeeDTOSaved;

    }

   // @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}",fallbackMethod ="getDefaultDepartment")
    public APIResponseDTO getEmployeeById(Long id) {

        LOGGER.info("inside GetEmploye method");
       Optional<Employee> employee = employeeRepository.findById(id);

//       ResponseEntity<DepartmentDTO> responseEntity =
//                 restTemplate.getForEntity("http://localhost:8080/api/departments/getDepartment/"
//                        + employee.get().getDepartmentCode(), DepartmentDTO.class);
//        DepartmentDTO departmentDTO = responseEntity.getBody();

      DepartmentDTO departmentDTO=  webClient.get()
                .uri("http://localhost:8080/api/departments/"
                        + employee.get().getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDTO.class)
                .block();

        OrganizationDTO  organizationDTO= webClient.get().
                uri("http://localhost:8083/api/organizations/" + employee.get().getOrganizationCode()).retrieve()
                .bodyToMono(OrganizationDTO.class).block();

       // DepartmentDTO departmentDTO = apiClient.getDepartment(employee.get().getDepartmentCode());
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee.get(),employeeDTO);
        APIResponseDTO apiResponseDTO = new APIResponseDTO();
        apiResponseDTO.setEmployeeDTO(employeeDTO);
        apiResponseDTO.setDepartmentDTO(departmentDTO);
        apiResponseDTO.setOrganizationDTO(organizationDTO);
        return apiResponseDTO;

    }
    public APIResponseDTO getDefaultDepartment(Long id, Exception exception) {
        LOGGER.info("inside getDefaultDepartment  method");
        Optional<Employee> employee = employeeRepository.findById(id);

        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentCode("DP001");
        departmentDTO.setDepartmentName("Departmennt");
        departmentDTO.setDepartmentDescription("Departmant creator");

        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee.get(),employeeDTO);
        APIResponseDTO apiResponseDTO = new APIResponseDTO();
        apiResponseDTO.setEmployeeDTO(employeeDTO);
        apiResponseDTO.setDepartmentDTO(departmentDTO);
        return apiResponseDTO;
    }
}
