package restcontroller.restcontroller.Models.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import restcontroller.restcontroller.Models.Entity.Item;

@Repository
public class ItemDaoImp implements IItemDao{

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Item> findAll() {
        // TODO Auto-generated method stub
        return em.createQuery("from item").getResultList();
    }

    @Transactional
    @Override
    public void Save(Item Item) {
        // TODO Auto-generated method stub
        if(Item.getId()!=null && Item.getId()>0){
            em.merge(Item);
        }
        else{
            em.persist(Item);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Item findOne(Long id) {
        // TODO Auto-generated method stub
        return em.find(Item.class, id);
    }

    @Transactional
    @Override
    public void Delete(Long id) {
        // TODO Auto-generated method stub
        Item Item=findOne(id);
        em.remove(Item);
    }
    
}
