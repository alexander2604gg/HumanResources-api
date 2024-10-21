package com.alexandersaul.rrhh_project.repository;

import com.alexandersaul.rrhh_project.model.entity.UserSec;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSecRepository extends CrudRepository<UserSec , Integer> {
    Optional<UserSec> findUserSecByUserName (String userName);
}
