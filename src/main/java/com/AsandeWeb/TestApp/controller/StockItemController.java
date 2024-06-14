//package com.AsandeWeb.TestApp.controller;

//import com.AsandeWeb.TestApp.repository.stockItemsCollectionRepository;
import com.AsandeWeb.TestApp.model.Stock_Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
/*
@RestController
@RequestMapping("/stockItems")
public class StockItemController {

    public final stockItemsCollectionRepository repository;

    @Autowired
    public StockItemController(stockItemsCollectionRepository repository) throws IOException {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Stock_Item> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Stock_Item findById( @PathVariable Integer id){
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Stock Item does not exist"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void Create(@RequestBody Stock_Item item){
        repository.save(item);
    }


}
*/