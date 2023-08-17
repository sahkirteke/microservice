package com.ms.organizationservice.service;


import com.ms.organizationservice.entity.DTO.OrganizationDTO;
import com.ms.organizationservice.entity.Organization;
import com.ms.organizationservice.repository.OrganizationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService{

    private OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public OrganizationDTO saveOrganization(OrganizationDTO organizationDto) {

        // convert OrganizationDto into Organization jpa entity
        Organization organization = new Organization();
        BeanUtils.copyProperties(organizationDto,organization);

        Organization savedOrganization = organizationRepository.save(organization);

        OrganizationDTO organizationDTOSaved = new OrganizationDTO();
        BeanUtils.copyProperties(savedOrganization,organizationDTOSaved);

        return organizationDTOSaved;
    }


    public OrganizationDTO getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        OrganizationDTO organizationDTO = new OrganizationDTO();
        BeanUtils.copyProperties(organization,organizationDTO);
        return organizationDTO;
    }
}