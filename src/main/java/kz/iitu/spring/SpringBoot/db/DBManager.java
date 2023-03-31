package kz.iitu.spring.SpringBoot.db;

import java.util.ArrayList;

public class DBManager {

    private static ArrayList<Items> allItems = new ArrayList<>();

    private static Long id = 5L;

    static {

        allItems.add(new Items(1l, "Iphone 12", 300000, 30));
        allItems.add(new Items(2l, "Iphone 13", 350000, 50));
        allItems.add(new Items(3l, "Iphone 14", 400000, 40));
        allItems.add(new Items(4l, "Iphone 11", 250000, 10));

    }

    public static ArrayList<Items> getAllItems() {
        return allItems;
    }

    public static void addItem(Items item){
        item.setId(id);
        allItems.add(item);
        id++;
    }
    public static Items getItem(Long id){
        for(Items it : allItems){
            if(it.getId()==id)
                return it;
        }
        return null;
    }
}
