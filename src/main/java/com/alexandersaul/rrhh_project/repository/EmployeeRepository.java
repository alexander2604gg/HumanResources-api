package com.alexandersaul.rrhh_project.repository;

import com.alexandersaul.rrhh_project.model.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee , Integer> {
}
