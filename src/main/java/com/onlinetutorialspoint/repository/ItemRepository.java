package com.onlinetutorialspoint.repository;

import com.onlinetutorialspoint.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {

    @Autowired
    JdbcTemplate template;

    public List<Item> getAllItems() {
        List<Item> items = template.query("select id, name,category from item",(result,rowNum)-> new Item(result.getInt("id"),
                result.getString("name"),result.getString("category")));
        return items;
    }

    public Item getItem(int itemId) {
        String query = "SELECT * FROM ITEM WHERE ID=?";
        Item item = template.queryForObject(query,new Object[]{itemId},new BeanPropertyRowMapper<>(Item.class));
        return item;
    }

    public int addItem(int id,String name,String category) {
        String query = "INSERT INTO ITEM VALUES(?,?,?)";
        return template.update(query,id,name,category);

    }

    public int deleteItem(int id) {
        String query = "DELETE FROM ITEM WHERE ID =?";
        return template.update(query,id);
    }
}
