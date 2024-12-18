package restcontroller.restcontroller.Models.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import restcontroller.restcontroller.Models.Entity.Almacen;

@Repository
public class AlmacenDaoImp implements IAlmacenDao{

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Almacen> findAll() {
        // TODO Auto-generated method stub
        return em.createQuery("from almacen").getResultList();
    }

    @Transactional
    @Override
    public void Save(Almacen almacen) {
        // TODO Auto-generated method stub
        if(almacen.getId()!=null && almacen.getId()>0){
            em.merge(almacen);
        }
        else{
            em.persist(almacen);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Almacen findOne(Long id) {
        // TODO Auto-generated method stub
        return em.find(Almacen.class, id);
    }

    @Transactional
    @Override
    public void Delete(Long id) {
        // TODO Auto-generated method stub
        Almacen almacen=findOne(id);
        em.remove(almacen);
    }
    
}
