import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private static AtomicInteger lastId = new AtomicInteger();
    final private int orderID;
    final private int customerID;
    final private Map<Integer, Integer> products;
    private boolean isConfirmed = false;
    final private String orderDate;
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm");
    Order(int customerID, Map<Integer, Integer> products) {
        this.orderID = lastId.incrementAndGet();
        this.customerID = customerID;
        this.products = products;
        this.orderDate = LocalDateTime.now().format(myFormatObj);
    }

//    void confirmOrder(List<Product> productList) {
//        for (: productList) {
//
//        }
//    }


    @Override
    public String toString() {
        return "OrderID: " + orderID + "\n"
                + "CustomerID: " + customerID + "\n"
                + "Products: " + products + "\n"
                + "Date of order: " + orderDate;
    }
}
