import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class ShoppingCart implements Searchable {
    private Map<Integer, Integer> cart = new HashMap<Integer, Integer>();

    public Map<Integer, Integer> getCart() {
        return cart;
    }

    void addToCart(int productID, int quantity, List<Product> productList) {
        Product addableProduct = findProduct(productID, productList);
        if (addableProduct != null) {
            if (addableProduct.getQuantityInStock() >= quantity){
                cart.put(addableProduct.getProductID(), quantity);
                System.out.println("Savatga maxsulot qo'shildi");
            }
            else System.out.println("Mahsulotlar ro'yxatida berilgan maxsulot yetarli emas");
        }
        else System.out.println("Mahsulotlar ro'yxatida berilgan maxsulot yo'q");
    }

    void increaseQuantity(int productID, List<Product> productList) {
        Product product = findProduct(productID, productList);
        if (this.getCart().get(productID) != null) {
            if (product.getQuantityInStock() > this.getCart().get(productID)) {
                int temp = this.getCart().get(productID);
                temp++;
                this.getCart().put(productID, temp);
            } else {
                this.getCart().put(productID, product.getQuantityInStock());
            }
        } else System.out.println("Bunday maxsulot yo'q");
    }

    void decreaseQuantity(int productID) {
        if (this.getCart().get(productID) != null) {
            int temp = this.getCart().get(productID);
            if (temp > 1) temp -= 1;
            else System.out.println("Mahsulot miqdori 1 dan kichik bo'lishi mumkin emas");
            this.getCart().put(productID, temp);
        } else System.out.println("Bunday maxsulot yo'q");
    }

    double calculateTotal(List<Product> productList) {
        double totalPrice = 0.0;
        for (Map.Entry<Integer, Integer> product: cart.entrySet()) {
            totalPrice += (findProduct(product.getKey(), productList).getPrice() * product.getValue()) ;
        }
        return totalPrice;
    }

    void removeFromCart(int productID) {
        if(this.cart.get(productID) != null) this.cart.remove(productID);
    }

    void removeAllFromCart() {
        this.cart.clear();
    }

    void viewCart(List<Product> productList) {
        for (Map.Entry<Integer, Integer> product: cart.entrySet()) {
            System.out.println(findProduct(product.getKey(), productList).getName() + ": " + product.getValue());
        }
        System.out.println("Total price: " + this.calculateTotal(productList));
    }
}
