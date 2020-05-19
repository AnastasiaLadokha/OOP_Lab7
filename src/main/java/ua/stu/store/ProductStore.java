package ua.stu.store;

import ua.stu.event.IProductListener;
import ua.stu.event.ProductEvent;
import ua.stu.model.IWeight;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProductStore implements Serializable {
    List<IProductListener> productListeners = new CopyOnWriteArrayList<>();
    private IWeight[] arr = new IWeight[3];
    private int count = 0;

    public IWeight[] getArr() {
        return Arrays.copyOf(arr, count);
    }

    public void addProductListener(IProductListener listener){
        productListeners.add(listener);
    }

    public void removeProductListener(IProductListener listener){
        productListeners.remove(listener);
    }

    protected void fireProductEvent(ProductEvent productEvent){
        productListeners.forEach((lsn) -> lsn.onProductEvent(productEvent));
    }

    public void add(IWeight newProduct) {
        if (arr.length == count)
            arr = Arrays.copyOf(arr, count + count / 2);
        arr[count++] = newProduct;
        fireProductEvent(new ProductEvent(this, newProduct));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Перелік брусів:\n");
        for (int i = 0; i < count; i++) {
            sb.append(arr[i]).append("\n");
        }
        return sb.toString();
    }
}
