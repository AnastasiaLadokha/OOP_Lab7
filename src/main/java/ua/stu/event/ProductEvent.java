package ua.stu.event;

import ua.stu.model.IWeight;

import java.util.EventObject;

public class ProductEvent extends EventObject {
    private IWeight product;
    private long time;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ProductEvent(Object source, IWeight product) {
        super(source);
        this.product = product;
        this.time = System.currentTimeMillis();
    }

    public IWeight getProduct() {
        return product;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return time % 1000 + " : " + product;
    }
}
