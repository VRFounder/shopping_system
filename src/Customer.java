import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer implements Searchable{
    private static AtomicInteger lastId = new AtomicInteger();
    private String name;
    private int customerID;

    ShoppingCart cart;
    Customer(String name) {
        this.customerID = lastId.incrementAndGet();
        this.name = name;
        this.cart = new ShoppingCart();
    }

    public String getName() {
        return name;
    }

    public int getCustomerID() {
        return customerID;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setName(String name) {
        this.name = name;
    }

}
