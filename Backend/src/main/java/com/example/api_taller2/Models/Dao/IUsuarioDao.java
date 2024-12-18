package com.example.api_taller2.Models.Dao;



import com.example.api_taller2.Models.Entity.Usuario;

import java.util.List;

public interface IUsuarioDao{
    public List<Usuario> findAll();

    public void Save(Usuario usuario);

    public Usuario findOne (Long id);
    
    public void Delete(Long id);

    public Usuario findByUsername(String username);
}
