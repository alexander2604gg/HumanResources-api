package com.alexandersaul.rrhh_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ActiveContractExistsException extends RuntimeException{
    public ActiveContractExistsException() {
        super("El empleado ya tiene un contrato activo");
    }
}
