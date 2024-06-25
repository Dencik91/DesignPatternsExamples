package example;

public class ProductFactory {


    private static Product createBaseProduct(String type, String name, double price) {
        Product product = null;
        if (type.equals("phone")) {
            product = new Phone();
        } else if (type.equals("printer")) {
            product = new Printer();
        }
        if (product != null) {
            product.setName(name);
            product.setPrice(price);
        }
        return product;
    }

    public static Product createProduct(String type, String name, double price, int diagonal) {
        Product product = createBaseProduct(type, name, price);
        ((Phone)product).setDiagonal(diagonal);
        return product;
    }

    public static Product createProduct(String type, String name, double price, String format) {
        Product product = createBaseProduct(type, name, price);
        ((Printer)product).setFormat(format);
        return product;
    }
}
