package com.example.api_taller2.Models.Dao;

import com.example.api_taller2.Models.Entity.HistorialTransferencias;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class HistorialTransferenciasDaoImp implements IHistorialTransferenciasDao{

    @PersistenceContext
    private EntityManager em;
    
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<HistorialTransferencias> findAll() {
        // TODO Auto-generated method stub
        return em.createQuery("from Historial").getResultList();
    }

    @Transactional
    @Override
    public void Save(HistorialTransferencias historialTransferencias) {
        // TODO Auto-generated method stub
        if(historialTransferencias.getId()!=null && historialTransferencias.getId()>0){
            em.merge(historialTransferencias);
        }
        else{
            em.persist(historialTransferencias);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public HistorialTransferencias findOne(Long id) {
        // TODO Auto-generated method stub
        return em.find(HistorialTransferencias.class, id);
    }

    @Transactional
    @Override
    public void Delete(Long id) {
        // TODO Auto-generated method stub
        HistorialTransferencias historialTransferencias=findOne(id);
        em.remove(historialTransferencias);
    }
    
}
