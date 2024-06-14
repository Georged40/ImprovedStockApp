package com.AsandeWeb.TestApp.service.serviceImplementation;

import com.AsandeWeb.TestApp.model.Stock_Item;
import com.AsandeWeb.TestApp.repository.stockItemRepo;
import com.AsandeWeb.TestApp.service.stockItemService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;


@AllArgsConstructor
@Service
@Slf4j
@Transactional

public class stockItemServiceImplementation implements stockItemService {
    private final stockItemRepo stockItemRepo;

    @Override
     public Stock_Item create(Stock_Item stockItem) {
        log.info("Saving new stockItem: {}",stockItem.getDescription());
        return stockItemRepo.save(stockItem);
    }

    @Override
    public Stock_Item update(Integer id, Stock_Item stockItem) {
        return stockItemRepo.save(stockItem);
    }

    @Override
    public Stock_Item findByIDFromSQL(Integer id) {
        return stockItemRepo.findByIDFromSQL(id);
    }


    public void reduceQty(Integer id, double quantity){
        Optional<Stock_Item> updatingStockItem = stockItemRepo.findById(id).filter(stockItem -> {
        stockItem.setQty(stockItem.getQty()-quantity);
            stockItemRepo.save(stockItem);
            return true;
        });

    }

    public Stock_Item reducedQty(Integer id,Stock_Item stockItem){
        Stock_Item holdQty = stockItemRepo.findById(id).get();
        double oldQty = holdQty.getQty();
        double price = holdQty.getPrice();
        double parLevel = holdQty.getParLevel();
        double providedQty = stockItem.getQty();
        double newQty = oldQty - providedQty;
        holdQty.setQty(newQty);
        holdQty.setValue(newQty * price);
        holdQty.setOrderQty(parLevel-newQty);
        return stockItemRepo.save(holdQty);
    }

    public Stock_Item increasedQty(Integer id,Stock_Item stockItem){
        Stock_Item holdQty = stockItemRepo.findById(id).get();
        double oldQty = holdQty.getQty();
        double price = holdQty.getPrice();
        double parLevel = holdQty.getParLevel();
        double providedQty = stockItem.getQty();
        double newQty = oldQty + providedQty;
        holdQty.setQty(newQty);
        holdQty.setValue(newQty * price);
        holdQty.setOrderQty(parLevel-newQty);
        return stockItemRepo.save(holdQty);
    }

    public Stock_Item checkBeforeModify(Integer id,Stock_Item stockItem){
        Stock_Item holdQty = stockItemRepo.findById(id).get();
        double oldQty = holdQty.getQty();
        double newQty;
        if(oldQty > 1){
            System.out.println("Update wont be possible");
        }else {
         holdQty = stockItem;
        // return stockItemRepo.save(holdQty);
        }
        return stockItemRepo.save(holdQty);
    }

        ;

    @Override
    public Collection<Stock_Item>list(int limit) {
        log.info("Fetching the stockItems");
        return stockItemRepo.findAll(PageRequest.of(0,limit)).toList();
    }

   /* @Override
    public Stock_Item updateQty(Integer id) {
        return stockItemRepo.updateQty(id);
    }*/













    public Stock_Item orderStockItem(Stock_Item stockItem) throws IOException {


        String myHeadLine = "Item No" + "Item Description" + "     " + "UOM" + "        " + "Price" + "        " + "Order Qty" + "\n";
        int counter = 1;
        String baseFilePath ="C:\\Users\\ProBook\\Desktop\\Test-App\\src\\main\\java\\com\\AsandeWeb\\TestApp\\Reports\\orders" + counter +".txt";
        File currentFile = new File(baseFilePath);
        BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile,true));
        Pattern pattern = Pattern.compile("|", Pattern.LITERAL);

        String label5Formatted = String.format("%-15s|", "Item No");
        String label1Formatted = String.format("%-15s|", "Description");
        String label2Formatted = String.format("%-15s|", "UOM");
        String label3Formatted = String.format("%-15s|", "Price");
        String label4Formatted = String.format("%-15s|", "Order Qty");
        String label6Formatted = String.format("%-15s|", "Value");


        String  createdItemsReportFieldHeading = label5Formatted + label1Formatted + label2Formatted + label3Formatted + label4Formatted + label6Formatted;

        while (currentFile.length() == 0){
            writer.write("\n" +createdItemsReportFieldHeading);

        }


        double itemNumberPassed = stockItem.getId();
        String orderItemDescription = stockItem.getDescription();
        double orderQty = stockItem.getQty();
        double price = stockItem.getPrice();
        String UOM = stockItem.getUom();
        double value = price * orderQty;


        String itemNumberFormated = String.format("%-15s|",itemNumberPassed);
        String descriptionFormated = String.format("%-15s|", orderItemDescription);
        String uomFormated = String.format("%-15s|", UOM);
        String priceFormated = String.format("%-15f|", price);
        String orderedQtyFormated = String.format("%-15f|", orderQty);
        String valueFormated = String.format("%-15f|", value);
        String orderedItem = itemNumberFormated + descriptionFormated + uomFormated+ priceFormated + orderedQtyFormated + valueFormated;


        writer.append("\n" + orderedItem);
        writer.close();
        counter++;
        return stockItem;
    }

    @Override
    public List<Stock_Item> getAllFromSQL() {
        return null;
    }

    @Override
    public Stock_Item get(Integer id) {
        log.info("Fetching stockItem with id : {}", id);
        return stockItemRepo.findById(id).get();
    }

    @Override
    public Boolean delete(Integer id) {
        log.info("Deleting the stockItem with ID : {}",id);
        stockItemRepo.deleteById(id);
        return true;
    }

    public Boolean delete(String description) {
        log.info("Deleting the stockItem by description : {}",description);
        stockItemRepo.delete(stockItemRepo.findByDescription(description));
        return true;
    }


}
