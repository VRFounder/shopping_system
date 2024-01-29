import java.util.List;

public interface Searchable {

    default Product findProduct(int productID, List<Product> productList) {
        for (Product product : productList) {
            if (product.getProductID() == productID) return product;
        }
        return null;
    }

}
