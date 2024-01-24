package interfaces;

import models.Basket;

public interface IOrderListener {
    public void OnOrder(Basket basket);
}
