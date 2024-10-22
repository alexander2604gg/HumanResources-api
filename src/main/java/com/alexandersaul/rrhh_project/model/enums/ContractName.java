package com.alexandersaul.rrhh_project.model.enums;

public enum ContractName {
    INDEFINIDO,
    PLAZO_FIJO,
    PRACTICAS;

    @Override
    public String toString() {
        if (this == ContractName.PLAZO_FIJO) {
            return "PLAZO FIJO";
        }
        return this.name();
    }
}

