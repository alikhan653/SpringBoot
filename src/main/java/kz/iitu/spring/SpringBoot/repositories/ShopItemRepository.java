package kz.iitu.spring.SpringBoot.repositories;

import jakarta.transaction.Transactional;
import kz.iitu.spring.SpringBoot.entities.ShopItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ShopItemRepository extends JpaRepository<ShopItems, Long> {

    List<ShopItems> findAllByPriceGreaterThanAndAmountLessThan(double price, int amount);

}
