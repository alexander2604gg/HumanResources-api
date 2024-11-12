package com.alexandersaul.rrhh_project.service.impl;

import com.alexandersaul.rrhh_project.exception.ResourceNotFoundException;
import com.alexandersaul.rrhh_project.model.entity.Job;
import com.alexandersaul.rrhh_project.repository.JobRepository;
import com.alexandersaul.rrhh_project.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements IJobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> findByEmployeeId() {
        return List.of();
    }

    @Override
    public Job findEntityById(Integer jobId) {
        return jobRepository.findById(jobId).orElseThrow(
                () -> new ResourceNotFoundException("Job" , "jobId" , jobId.toString())
        );
    }

}
