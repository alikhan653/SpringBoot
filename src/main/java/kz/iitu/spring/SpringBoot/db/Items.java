package kz.iitu.spring.SpringBoot.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Items {

    private Long id;
    private String name;
    private double price;
    private int amount;

}
