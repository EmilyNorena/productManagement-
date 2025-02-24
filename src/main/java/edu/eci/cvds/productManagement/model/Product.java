package edu.eci.cvds.productManagement.model;

public class Product {
    private String name;
    private Float price;
    private Integer quantity;
    private String category;
    public Product (String name, Float price, Integer quantity, String category){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }
    public Integer getQuantity(){
        return quantity;
    }
    public Float getPrice(){return price;}
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
