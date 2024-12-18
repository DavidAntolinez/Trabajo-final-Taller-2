package restcontroller.restcontroller.Models.Entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class HistorialTransferencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date Fecha;

    @NotNull
    @NotEmpty
    private Long AlmacenOrigenId;

    @NotNull
    @NotEmpty
    private Long AlmacenDestinoId;

    @NotNull
    @NotEmpty
    private Long ItemId;

    
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
