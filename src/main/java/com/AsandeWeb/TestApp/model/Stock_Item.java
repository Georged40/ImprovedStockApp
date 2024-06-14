package com.AsandeWeb.TestApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock_Item {
    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
   @Column(unique = true)
   @NotEmpty(message = "Description cannot be empty")
    String description;
    String uom;
    double qty;
    double price;
    double value;
    double parLevel;
    double orderQty;
    LocalDateTime dateCreated;
    LocalDateTime dateUpdated;

    public double getQty() {
        return qty;
    }
}
