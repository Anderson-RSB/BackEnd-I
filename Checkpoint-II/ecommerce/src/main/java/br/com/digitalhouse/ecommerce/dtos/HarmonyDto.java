package br.com.digitalhouse.ecommerce.dtos;

import br.com.digitalhouse.ecommerce.entities.Harmony;

import java.io.Serializable;

public class HarmonyDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nameplate;

    public HarmonyDto() {
    }

    public HarmonyDto(Integer id, String nameplate) {
        this.id = id;
        this.nameplate = nameplate;
    }

    public HarmonyDto(Harmony harmony) {
        this.id = harmony.getId();
        this.nameplate = harmony.getNamePlate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameplate() {
        return nameplate;
    }

    public void setNameplate(String nameplate) {
        this.nameplate = nameplate;
    }

}