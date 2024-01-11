package com.example.gestionlogiciel.keys;


import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.io.Serializable;

@Embeddable
public class ComposantKey implements Serializable {
    String code ;

    @Enumerated(EnumType.ORDINAL)
    Version version;

    public ComposantKey() {

    }

    public ComposantKey(String code, Version version) {
        this.code = code;
        this.version = version;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }
}
