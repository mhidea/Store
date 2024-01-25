package test;

import java.util.List;

import catalogs.PaymentMethods;
import catalogs.ShippingMethods;
import models.Basket;
import models.Product;
import models.User;
import services.ServiceFactory;

public class BasketTest {
    public static void main(String[] args) {

        try {
            User user = new User("1");
            List<Basket> b = Basket.getAll(user);

            if (b.isEmpty()) {
                Basket basket = new Basket(user);
                Product p1 = new Product("1");
                Product p2 = new Product("2");
                Product p3 = new Product("3");
                basket.addToBasket(p1, 10);
                basket.addToBasket(p2, 20);
                basket.addToBasket(p3, 30);
                basket.save();
            } else {
                for (Basket basket : b) {
                    PaymentMethods paymentMethods = ServiceFactory.getInstance().getPaymentMethods();
                    ShippingMethods shippingMethods = ServiceFactory.getInstance().getShippingMethods();

                    basket.finalize(paymentMethods.getMethod("Melli Bank"), shippingMethods.getMethod("aloPeik"));
                    System.out.println(basket.getTotal());
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
