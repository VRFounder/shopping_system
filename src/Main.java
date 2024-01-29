import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        Customer customer = new Customer("Feruz");
        Scanner scan = new Scanner(System.in);

        // Adding 100 dummy products
        for (int i = 1; i <= 10; i++) {
            productList.add(new Product("Product" + i, 10.99 * i, 5 * i));
        }

        for (Product product: productList) {
            System.out.println(product);
            System.out.println("_____________");
            System.out.println();
        }

        System.out.println("Enter the id of the product that you want to add to cart: ");
        int id = scan.nextInt();
        System.out.println("Enter the quantity of the product: ");
        customer.cart.addToCart(id, scan.nextInt(), productList);

        System.out.println("Enter the id of the product that you want increase in quantity: ");
        id = scan.nextInt();
        customer.cart.increaseQuantity(id, productList);
        customer.cart.viewCart(productList);

        System.out.println("Enter the id of the product that you want increase in quantity: ");
        id = scan.nextInt();
        customer.cart.increaseQuantity(id, productList);
        customer.cart.viewCart(productList);

        System.out.println("Enter the id of the product that you want increase in quantity: ");
        id = scan.nextInt();
        customer.cart.increaseQuantity(id, productList);
        customer.cart.viewCart(productList);

        System.out.println("Enter the id of the product that you want decrease in quantity: ");
        id = scan.nextInt();
        customer.cart.decreaseQuantity(id);
        customer.cart.viewCart(productList);


    }
}