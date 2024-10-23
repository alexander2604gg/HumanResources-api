package com.alexandersaul.rrhh_project.service.impl;

import com.alexandersaul.rrhh_project.exception.ResourceNotFoundException;
import com.alexandersaul.rrhh_project.model.entity.DocumentType;
import com.alexandersaul.rrhh_project.repository.DocumentTypeRepository;
import com.alexandersaul.rrhh_project.service.IDocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentTypeServiceImpl implements IDocumentTypeService {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @Override
    public DocumentType findById(Integer documentTypeId) {
        return documentTypeRepository.findById(documentTypeId).orElseThrow(
                () -> new ResourceNotFoundException("DocumentType" , "documentTypeId" , documentTypeId.toString())
        );
    }
}
