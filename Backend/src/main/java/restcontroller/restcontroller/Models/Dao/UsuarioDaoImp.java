package restcontroller.restcontroller.Models.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import restcontroller.restcontroller.Models.Entity.Usuario;

@Repository
public class UsuarioDaoImp implements IUsuarioDao{

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll() {
        // TODO Auto-generated method stub
        return em.createQuery("from usuario").getResultList();
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
    
}
