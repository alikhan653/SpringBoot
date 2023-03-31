package kz.iitu.spring.SpringBoot.services;

import kz.iitu.spring.SpringBoot.db.Items;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ItemService {

    private ArrayList<Items> allItems;
    private Long id;

    public ItemService(){
        allItems = new ArrayList<>();
        allItems.add(new Items(1l, "Iphone 12", 300000, 30));
        allItems.add(new Items(2l, "Iphone 13", 350000, 50));
        allItems.add(new Items(3l, "Iphone 14", 400000, 40));
        allItems.add(new Items(4l, "Iphone 11", 250000, 10));
        id=5L;
    }

    public ArrayList<Items> getAllItems() {
        return allItems;
    }

    public void addItem(Items item){
        item.setId(id);
        allItems.add(item);
        id++;
    }
    public  Items getItem(Long id){
        for(Items it : allItems){
            if(it.getId()==id)
                return it;
        }
        return null;
    }

}
