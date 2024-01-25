package test;

import models.Product;
import models.User;

public class CreateObjects {
    public static void main(String[] args) {

        User User;
        try {
            User = new models.User("1");

            Product product;
            for (int i = 1; i < 4; i++) {
                product = new Product(User);
                product.setName("Book_" + i);
                product.setCount(200);
                product.setPrice(1500);
                product.save();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
