package restcontroller.restcontroller.Models.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Min(1)
    private int CapacidadTotal;

    @Min(0)
    private int ItemsAlmacenados;

    @NotNull
    @NotEmpty
    private Long usuarioId;

    

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    

    public int getCapacidadTotal() {
        return CapacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        CapacidadTotal = capacidadTotal;
    }

    public int getItemsAlmacenados() {
        return ItemsAlmacenados;
    }

    public void setItemsAlmacenados(int itemsAlmacenados) {
        ItemsAlmacenados = itemsAlmacenados;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }


    
}
