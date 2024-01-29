import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    private static AtomicInteger lastId = new AtomicInteger();
    private int productID;
    private String name;
    private double price;
    private int quantityInStock;

    Product(String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.productID = lastId.incrementAndGet();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
            System.out.println("Yangi narx kiritildi");
        }
        else System.out.println("Narx noto'g'ri kiritilgan");
    }

    public void setQuantityInStock(int quantity) {
        if (quantity >= 0) {
            quantityInStock = quantity;
            System.out.println("Yangi narx kiritildi");
        }
        else System.out.println("Narx noto'g'ri kiritilgan");
    }


    @Override
    public String toString() {
        return "ID: " + productID
                + "\nName: " + name
                + "\nPrice: $" + price
                + "\nStock: " + quantityInStock;
    }
}
