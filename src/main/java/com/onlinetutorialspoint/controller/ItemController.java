package com.onlinetutorialspoint.controller;
import java.util.List;
import com.onlinetutorialspoint.model.Item;
import com.onlinetutorialspoint.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping("/getAllItems")
    public List<Item> getAllItems(){
        return itemRepository.getAllItems();
    }

    @RequestMapping("/getItem")
    public Item getItem(@RequestParam("itemId") int itemId){
        return itemRepository.getItem(itemId);
    }

    @RequestMapping("/addItem")
    public String addItem(@RequestParam("id") int id,@RequestParam("name") String name,
                        @RequestParam("category") String category) {
        if (itemRepository.addItem(id, name, category) >= 1) {
            return "Item Added Successfully";
        }
        else
            {
            return "Something went wrong !";
        }
    }

    @RequestMapping("/deteteItem")
    public String deteteItem(@RequestParam("itemId") int itemId){
        if(itemRepository.deleteItem(itemId) >= 1){
            return "Item Deleted Successfully";
        }
        else{
            return "Something went wrong !";
        }
    }
}