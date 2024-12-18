package com.example.api_taller2.Models.Dao;



import com.example.api_taller2.Models.Entity.Item;

import java.util.List;


public interface IItemDao{
    
    public List<Item> findAll();

    public void Save(Item item);

    public Item findOne (Long id);
    
    public void Delete(Long id);
}
