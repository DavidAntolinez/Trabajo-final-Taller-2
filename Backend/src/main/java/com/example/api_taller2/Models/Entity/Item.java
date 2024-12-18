package com.example.api_taller2.Models.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    @NotEmpty
    private String Nombre;

    @NotNull
    @NotEmpty
    private String Descripcion;

    @NotNull
    private Long AlmacenId;

    public Item(String nombre, String descripcion, Long almacenId) {
        Nombre = nombre;
        Descripcion = descripcion;
        AlmacenId = almacenId;
    }

    public Item() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Long getAlmacenId() {
        return AlmacenId;
    }

    public void setAlmacenId(Long almacenId) {
        AlmacenId = almacenId;
    }
    
}
