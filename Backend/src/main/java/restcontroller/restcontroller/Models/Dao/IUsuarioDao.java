package restcontroller.restcontroller.Models.Dao;

import java.util.List;

import restcontroller.restcontroller.Models.Entity.Usuario;

public interface IUsuarioDao{
    public List<Usuario> findAll();

    public void Save(Usuario usuario);

    public Usuario findOne (Long id);
    
    public void Delete(Long id);
}
