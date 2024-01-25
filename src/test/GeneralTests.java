package test;

import java.util.ArrayList;
import java.util.List;

import models.Basket;

public class GeneralTests {
    public static void main(String[] args) {
        try {
            Basket b = new Basket("1");
            int c = b.getItems().stream().reduce(0, (a, item) -> {
                return Integer.parseInt(item.getCount());
            }, Integer::sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
