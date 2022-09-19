package br.com.digitalhouse.ecommerce.dtos;

import br.com.digitalhouse.ecommerce.entities.Grape;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class GrapeDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String namegrape;
    private Set<HarmonyDto> harmonies = new HashSet<>();

    public GrapeDto() {
    }

    public GrapeDto(Integer id, String namegrape) {
        this.id = id;
        this.namegrape = namegrape;
    }

    public GrapeDto(Grape grape) {
        this.id = grape.getId();
        this.namegrape = grape.getNameGrape();
        grape.getHarmonies().forEach(harmony -> this.harmonies.add(new HarmonyDto(harmony)));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamegrape() {
        return namegrape;
    }

    public void setNamegrape(String namegrape) {
        this.namegrape = namegrape;
    }

    public Set<HarmonyDto> getHarmonies() {
        return harmonies;
    }

    public void setHarmonies(Set<HarmonyDto> harmonies) {
        this.harmonies = harmonies;
    }

}