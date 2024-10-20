package com.alexandersaul.rrhh_project.repository;

import com.alexandersaul.rrhh_project.model.entity.UserSec;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSecRepository extends CrudRepository<UserSec , Integer> {
}
