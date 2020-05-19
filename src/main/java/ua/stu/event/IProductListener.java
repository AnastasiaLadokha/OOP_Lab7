package ua.stu.event;

import java.util.EventListener;

public interface IProductListener extends EventListener {
    public void onProductEvent(ProductEvent event);
}
