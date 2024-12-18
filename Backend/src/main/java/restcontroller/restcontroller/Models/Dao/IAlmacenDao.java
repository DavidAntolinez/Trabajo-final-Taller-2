package restcontroller.restcontroller.Models.Dao;

import java.util.List;

import restcontroller.restcontroller.Models.Entity.Almacen;

public interface IAlmacenDao{
    
    public List<Almacen> findAll();

    public void Save(Almacen almacen);

    public Almacen findOne (Long id);
    
    public void Delete(Long id);
}
