package com.AsandeWeb.TestApp.service;

import com.AsandeWeb.TestApp.model.Stock_Item;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface stockItemService {

     Stock_Item create(Stock_Item stockItem);
     Stock_Item update(Integer id,Stock_Item stockItem);
   // @Query(value = "UPDATE storesdb.stock_item SET qty=? WHERE id=?" newQty,2,nativeQuery = true)
   public Stock_Item findByIDFromSQL(@Param("id") Integer id);


    Collection<Stock_Item> list(int limit);

  //  public Stock_Item updateQty(@Param("idNum") Integer id);

    // public void orderStockItem(Stock_Item stockItem) throws IOException;
List <Stock_Item> getAllFromSQL();
    Stock_Item get(Integer id);
    Boolean delete(Integer id);


    Boolean delete(String description);
}
