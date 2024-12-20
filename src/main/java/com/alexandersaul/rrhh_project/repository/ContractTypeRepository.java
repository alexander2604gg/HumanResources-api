package com.alexandersaul.rrhh_project.repository;


import com.alexandersaul.rrhh_project.model.entity.ContractType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractTypeRepository extends JpaRepository<ContractType, Integer> {
}
