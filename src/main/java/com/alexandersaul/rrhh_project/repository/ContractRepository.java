package com.alexandersaul.rrhh_project.repository;

import com.alexandersaul.rrhh_project.model.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    List<Contract> findByEmployeeId (Integer employeeId);
}
