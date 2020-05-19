package ua.stu.event;

import ua.stu.model.IWeight;

import java.util.Date;
import java.util.EventObject;

public class ProductEvent extends EventObject {
    private IWeight product;
    private Date date = new Date();

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ProductEvent(Object source, IWeight product) {
        super(source);
        this.product = product;
    }

    public IWeight getProduct() {
        return product;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return date + " : " + product;
    }
}
