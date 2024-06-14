/*
package com.AsandeWeb.TestApp.repository;

import com.AsandeWeb.TestApp.model.Stock_Item;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class stockItemsCollectionRepository {

    private final List<Stock_Item> stockItemsList = new ArrayList<>();

    public stockItemsCollectionRepository(){

    }

    public List<Stock_Item> findAll() {
        return stockItemsList;
    }

    public Optional<Stock_Item> findById(Integer id){
       return stockItemsList.stream().filter(stockItem-> stockItem.getId().equals(id)).findFirst();
    }

    public void save(Stock_Item item){
        stockItemsList.add(item);
    }

    @PostConstruct
    private void init(){
        Stock_Item item = new Stock_Item(1000,"Butter","KG",10.0, 38.50,
                385.00,30.00,30.00-10.00, LocalDateTime.now(),null);

        stockItemsList.add(item);
    }
}
*/
