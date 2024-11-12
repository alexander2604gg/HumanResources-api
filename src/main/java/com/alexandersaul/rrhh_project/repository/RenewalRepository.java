package com.alexandersaul.rrhh_project.repository;

import com.alexandersaul.rrhh_project.model.entity.Renewal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RenewalRepository extends JpaRepository<Renewal , Integer> {
    List<Renewal> findByContractId (Integer contractId);
}
