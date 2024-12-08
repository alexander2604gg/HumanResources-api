package com.alexandersaul.rrhh_project.service.impl;

import com.alexandersaul.rrhh_project.dto.contract.ContractRegisterDto;
import com.alexandersaul.rrhh_project.dto.contract.ContractResponseDto;
import com.alexandersaul.rrhh_project.dto.contract.ContractUpdateDto;
import com.alexandersaul.rrhh_project.dto.contract.EmployeeContractsDto;
import com.alexandersaul.rrhh_project.exception.ActiveContractExistsException;
import com.alexandersaul.rrhh_project.exception.ResourceNotFoundException;
import com.alexandersaul.rrhh_project.mapper.ContractMapper;
import com.alexandersaul.rrhh_project.mapper.EmployeeMapper;
import com.alexandersaul.rrhh_project.model.entity.Contract;
import com.alexandersaul.rrhh_project.model.entity.ContractType;
import com.alexandersaul.rrhh_project.model.entity.Employee;
import com.alexandersaul.rrhh_project.model.entity.Job;
import com.alexandersaul.rrhh_project.repository.ContractRepository;
import com.alexandersaul.rrhh_project.service.IContractService;
import com.alexandersaul.rrhh_project.service.IContractTypeService;
import com.alexandersaul.rrhh_project.service.IEmployeeService;
import com.alexandersaul.rrhh_project.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {

    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private IJobService jobService;
    @Autowired
    private IContractTypeService contractTypeService;


    @Override
    public List<ContractResponseDto> getContractsByEmployeeId(Integer employeeId) {
        List<Contract> contractList = contractRepository.findByEmployeeId(employeeId);
        return contractMapper.toDtoList(contractList);
    }

    @Override
    public Page<ContractResponseDto> getContractsPaginated(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Contract> contractPage = contractRepository.findAll(pageable);

        List<ContractResponseDto> contractDtos = contractMapper.toDtoList(contractPage.getContent());

        return new PageImpl<>(contractDtos, pageable, contractPage.getTotalElements());

    }

    @Override
    public EmployeeContractsDto getContractByDocumentNumber(String documentNumber) {
        Employee employee = employeeService.findEntityByDocumentNumber(documentNumber);
        List<ContractResponseDto> contractResponseDtoList =  getContractsByEmployeeId(employee.getId());
        return new EmployeeContractsDto(employeeMapper.toDto(employee) , contractResponseDtoList);
    }

    @Transactional
    @Override
    public void registerContract(ContractRegisterDto contractRegisterDto) {

        if (this.hasActiveContract(contractRegisterDto.getEmployeeId())) {
            throw new ActiveContractExistsException();
        }

        Employee employee = employeeService.findEntityById(contractRegisterDto.getEmployeeId());
        Job job = jobService.findEntityById(contractRegisterDto.getJobId());
        ContractType contractType = contractTypeService.findEntityById(contractRegisterDto.getContractTypeId());

        Contract contract = contractMapper.toEntity(contractRegisterDto);
        contract.setEmployee(employee);
        contract.setJob(job);
        contract.setContractType(contractType);
        contract.setActive(true);

        contractRepository.save(contract);
    }


    @Transactional
    @Override
    public void updateContract(Integer contractId , ContractUpdateDto contractUpdateDto) {

        Contract contract = findEntityById(contractId);
        Job job = jobService.findEntityById(contractUpdateDto.getJobId());
        ContractType contractType = contractTypeService.findEntityById(contractUpdateDto.getContractTypeId());

        contract.setJob(job);
        contract.setContractType(contractType);
        contract.setStartDate(contractUpdateDto.getStartDate());
        contract.setEndDate(contractUpdateDto.getEndDate());
        contract.setGrossSalary(contractUpdateDto.getGrossSalary());
        contract.setContractPath(contractUpdateDto.getContractPath());

        contractRepository.save(contract);

    }

    @Override
    public Contract findEntityById(Integer contractId) {
        return contractRepository.findById(contractId).orElseThrow(
                () -> new ResourceNotFoundException("Contract" , "contractId" , contractId.toString())
        );
    }

    @Transactional
    @Override
    public void disableContract(Integer contractId) {
        Contract contract = findEntityById(contractId);
        contract.setActive(false);
        contract.getEmployee().setActive(false);
        contractRepository.save(contract);
    }

    @Override
    public boolean hasActiveContract(Integer employeeId) {
        List<Contract> contractList = contractRepository.findByEmployeeId(employeeId);
        return contractList.stream()
                .anyMatch(Contract::isActive);
    }


}
