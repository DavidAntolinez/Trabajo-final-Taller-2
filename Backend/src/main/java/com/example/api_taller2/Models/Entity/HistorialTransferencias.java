package com.example.api_taller2.Models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity(name = "Historial")
@Table(name = "historial")
public class HistorialTransferencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date Fecha;

    @NotNull
    private Long AlmacenOrigenId;

    @NotNull
    private Long AlmacenDestinoId;

    @NotNull
    private Long ItemId;

    @NotNull
    private Long UsuarioId;

//    public HistorialTransferencias(Long almacenOrigenId, Long almacenDestinoId, Long itemId, Long usuarioId) {
//        AlmacenOrigenId = almacenOrigenId;
//        AlmacenDestinoId = almacenDestinoId;
//        ItemId = itemId;
//        UsuarioId = usuarioId;
//
//    }

    public @NotNull Long getUsuarioId() {
        return UsuarioId;
    }

    public void setUsuarioId(@NotNull Long usuarioId) {
        UsuarioId = usuarioId;
    }

    public Long getAlmacenOrigenId() {
        return AlmacenOrigenId;
    }



    public void setAlmacenOrigenId(Long almacenOrigenId) {
        AlmacenOrigenId = almacenOrigenId;
    }



    public Long getAlmacenDestinoId() {
        return AlmacenDestinoId;
    }



    public void setAlmacenDestinoId(Long almacenDestinoId) {
        AlmacenDestinoId = almacenDestinoId;
    }



    public Long getItemId() {
        return ItemId;
    }



    public void setItemId(Long itemId) {
        ItemId = itemId;
    }



    @PrePersist
    public void perPersist(){
        Fecha= new Date();
    }

    

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

   



    public Long getId() {
        return Id;
    }



    public void setId(Long id) {
        Id = id;
    }

    
}
