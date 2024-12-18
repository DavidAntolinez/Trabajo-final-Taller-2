package restcontroller.restcontroller.Models.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import restcontroller.restcontroller.Models.Entity.HistorialTransferencias;

@Repository
public class HistorialTransferenciasDaoImp implements IHistorialTransferenciasDao{

    @PersistenceContext
    private EntityManager em;
    
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<HistorialTransferencias> findAll() {
        // TODO Auto-generated method stub
        return em.createQuery("from historial_Transferencias").getResultList();
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
