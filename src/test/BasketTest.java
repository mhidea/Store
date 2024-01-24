package test;

import java.util.List;

import models.Basket;
import models.Product;
import models.User;

public class BasketTest {
    public static void main(String[] args) {

        try {
            User user = new User("1");
            List<Basket> b = Basket.getAll(user);
            b.get(0).finalize(null, null);
            Basket basket = new Basket(user);
            Product p1 = new Product("1");
            Product p2 = new Product("2");
            Product p3 = new Product("3");
            basket.addToBasket(p1, 10);
            basket.addToBasket(p2, 20);
            basket.addToBasket(p3, 30);
            basket.save();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
