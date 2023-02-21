package com.example.springbootcrud.dto;

import jakarta.validation.constraints.*;

public class ProductsDto {

//    private int id;
    @NotBlank(message = "Name field is mandatory")
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
    private String name;
    @NotNull(message = "Price field is mandatory")
    private int price;
    private int totalPrice;
    @NotNull(message = "Quantity field is mandatory")
    @PositiveOrZero(message = "Quantity field is less than or equal to zero")
    private int quantity;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
