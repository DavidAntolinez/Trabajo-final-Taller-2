package restcontroller.restcontroller.Models.Dao;

import java.util.List;

import restcontroller.restcontroller.Models.Entity.Item;


public interface IItemDao{
    
    public List<Item> findAll();

    public void Save(Item item);

    public Item findOne (Long id);
    
    public void Delete(Long id);
}
