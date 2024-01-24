package test;

import models.Product;

public class CreateObjects {
    public static void main(String[] args) {

        Product product = new Product();
        product.setName("Book");
        product.setCount(200);
        product.setPrice(1500);
        product.save();
    }
}
