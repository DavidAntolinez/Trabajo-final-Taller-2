package com.example.api_taller2.Models.Dao;

import com.example.api_taller2.Models.Entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class UsuarioDaoImp implements IUsuarioDao{

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll() {
        // TODO Auto-generated method stub
        return em.createQuery("from Usuario").getResultList();
    }

    @Transactional
    @Override
    public void Save(Usuario Usuario) {
        // TODO Auto-generated method stub
        if(Usuario.getId()!=null && Usuario.getId()>0){
            em.merge(Usuario);
        }
        else{
            em.persist(Usuario);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario findOne(Long id) {
        // TODO Auto-generated method stub
        return em.find(Usuario.class, id);
    }

    @Transactional
    @Override
    public void Delete(Long id) {
        // TODO Auto-generated method stub
        Usuario Usuario=findOne(id);
        em.remove(Usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario findByUsername(String username) {
        List<Usuario> usuarios = findAll();
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return usuario;
            }
        }
        return null;
    }
    
}
