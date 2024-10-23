package com.alexandersaul.rrhh_project.service;

import com.alexandersaul.rrhh_project.model.entity.Job;

public interface IJobService {
    Job findEntityById (Integer jobId);
}
