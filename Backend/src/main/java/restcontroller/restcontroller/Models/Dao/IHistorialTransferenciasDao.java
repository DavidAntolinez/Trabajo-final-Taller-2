package restcontroller.restcontroller.Models.Dao;

import java.util.List;

import restcontroller.restcontroller.Models.Entity.HistorialTransferencias;


public interface IHistorialTransferenciasDao{
    
    public List<HistorialTransferencias> findAll();

    public void Save(HistorialTransferencias historialTransferencias);

    public HistorialTransferencias findOne (Long id);
    
    public void Delete(Long id);
}
