package com.example.demo.products.application.models;

public class ProductDTO {

    private Integer productId;
    private String name;
    private Integer price;
    private Integer discount;
    private Boolean state;
    private Integer typeOfProduct;

    public ProductDTO() {

    }

    public ProductDTO(Integer productId, String name, Integer price, Integer discount, Boolean state,
            Integer typeOfProduct) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.state = state;
        this.typeOfProduct = typeOfProduct;

    }

    public Integer getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(Integer typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

}
