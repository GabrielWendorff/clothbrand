package com.webdev.clothbrand.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoRoupa {
    CAMISA(1),
    CALCA(2),
    CASACO(3);

    private final int id;

    TipoRoupa(int id) {
        this.id = id;
    }

    @JsonValue
    public int getId() {
        return id;
    }

    @JsonCreator
    public static TipoRoupa fromId(int id) {
        for (TipoRoupa tipo : TipoRoupa.values()) {
            if (tipo.id == id) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("TipoRoupa inválido: " + id);
    }
}
