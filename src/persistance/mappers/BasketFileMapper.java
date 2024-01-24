package persistance.mappers;

import models.Basket;
import models.BasketItem;
import models.User;

public class BasketFileMapper extends FileMapper<Basket> {

    public BasketFileMapper(Class<Basket> class1) {
        super(class1);
    }

    @Override
    public Basket getModel(String data) {
        String[] ss = data.split(",");
        User user;
        Basket basket = null;
        try {
            user = new User(ss[1]);
            basket = new Basket(user);
            basket.setValues(ss);
            String[] is = ss[3].split("#");
            for (String string : is) {
                basket.addToBasket(new BasketItem(string));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
        return basket;
    }

}
