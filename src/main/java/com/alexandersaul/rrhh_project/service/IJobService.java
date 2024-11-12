package com.alexandersaul.rrhh_project.service;

import com.alexandersaul.rrhh_project.model.entity.Job;

import java.util.List;

public interface IJobService {
    List<Job> findByEmployeeId ();
    Job findEntityById (Integer jobId);
}
