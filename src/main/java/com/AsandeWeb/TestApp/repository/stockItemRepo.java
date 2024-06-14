package com.AsandeWeb.TestApp.repository;

import com.AsandeWeb.TestApp.model.Stock_Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface stockItemRepo extends JpaRepository<Stock_Item,Integer> {

    public final List<Stock_Item> stockItemsList = new ArrayList<>();


    public List<Stock_Item> findAll();
   /* public Stock_Item save(Stock_Item stockItem);*/

   // public Stock_Item findById(Integer id);

    @Query(value = "select * from storesdb.stock_item where id = :idNum ", nativeQuery = true)
    public Stock_Item findByIDFromSQL(@Param("idNum") Integer id);


 /*   @Modifying
    @Query("update stock_Item s set s.qty = qty-:quantity where s.id = :id")
    Stock_Item issueStockItem(@Param(value ="id" ) Integer id,@Param(value ="quantity" ) @RequestBody  double quantity);
 //   @Query(value="select qty from storesdb.stock_item where u.id :id", nativeQuery = true)*/


  //  @Query(value =
   //         " UPDATE qty SET qty = qty+ 40 where u.id =:idNum", nativeQuery = true)
   // public Stock_Item updateQty(@Param("idNum") Integer id);

   // @Query(value = "update storesdb.stock_item set qty = qty + ?1 where id = ?2;", nativeQuery = true)
   //public Stock_Item issueStock(@Param("newQty") double newQty,@Param("idNum")Integer id);
 //   @Modifying
 //   @Query(value =
 //           "update stock_item set qty= qty-10 id = :id", nativeQuery = true)


    Stock_Item findByDescription(String description);




   // Stock_Item findByID(Integer id);
 //   public void orderStockItem(Stock_Item stockItem);
}
