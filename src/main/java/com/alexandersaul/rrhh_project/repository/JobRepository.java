package com.alexandersaul.rrhh_project.repository;

import com.alexandersaul.rrhh_project.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job , Integer> {
}
