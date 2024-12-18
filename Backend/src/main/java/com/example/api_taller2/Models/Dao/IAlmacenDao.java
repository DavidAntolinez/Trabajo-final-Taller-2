package com.example.api_taller2.Models.Dao;



import com.example.api_taller2.Models.Entity.Almacen;

import java.util.List;

public interface IAlmacenDao{
    
    public List<Almacen> findAll();

    public void Save(Almacen almacen);

    public Almacen findOne (Long id);
    
    public void Delete(Long id);
}
