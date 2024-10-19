package com.alexandersaul.rrhh_project.model.enums;

public enum DocumentName {
    DNI,
    CARNET_DE_EXTRANJERIA;

    @Override
    public String toString() {
        if (this == DocumentName.CARNET_DE_EXTRANJERIA) {
            return "Carnet de Extranjería";
        }
        return this.name();
    }
}
