package kz.iitu.spring.SpringBoot.services;

import kz.iitu.spring.SpringBoot.entities.ShopItems;
import kz.iitu.spring.SpringBoot.repositories.ShopItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopItemService {

    @Autowired
    private ShopItemRepository shopItemRepository;


    public List<ShopItems> getAllItems(){
        return shopItemRepository.findAll();
    }

    public ShopItems getItem(Long id){
        Optional<ShopItems> opt = shopItemRepository.findById(id);
        return opt.orElse(null);
    }

    public void addItem(ShopItems item){
        shopItemRepository.save(item);
    }
    public void updateItem(ShopItems item){
        shopItemRepository.save(item);
    }
    public void deleteItem(Long id){
        shopItemRepository.deleteById(id);
    }
}
