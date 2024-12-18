package com.example.api_taller2.Models.Dao;


import com.example.api_taller2.Models.Entity.HistorialTransferencias;

import java.util.List;


public interface IHistorialTransferenciasDao{
    
    public List<HistorialTransferencias> findAll();

    public void Save(HistorialTransferencias historialTransferencias);

    public HistorialTransferencias findOne (Long id);
    
    public void Delete(Long id);
}
