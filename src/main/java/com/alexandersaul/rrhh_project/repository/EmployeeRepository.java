package com.alexandersaul.rrhh_project.repository;

import com.alexandersaul.rrhh_project.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Integer> {
    @Query("SELECT e FROM Employee e WHERE e.active = :isActive")
    Page<Employee> findActiveEmployees(@Param("isActive") boolean isActive, Pageable pageable);
    Optional<Employee> findByDocumentNumber (String documentNumber);
    Optional<Employee> findByUserId (Integer userId);
}
