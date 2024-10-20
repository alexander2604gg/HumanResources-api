package com.alexandersaul.rrhh_project.repository;

import com.alexandersaul.rrhh_project.model.entity.DocumentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeRepository extends CrudRepository<DocumentType , Integer> {
}
