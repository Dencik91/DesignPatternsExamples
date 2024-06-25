package example;

public class ProductFactory {


    private static Product createBaseProduct(String type, String name, double price) {
        Product product = null;
        switch (type) {
            case "phone" -> product = new Phone();
            case "printer" -> product = new Printer();
            case "laptop" -> product = new Laptop();
            default -> throw new IllegalArgumentException("Invalid type of product: "+type);
        }
        product.setName(name);
        product.setPrice(price);
        return product;
    }

    public static Product createProduct(String type, String name, double price, int diagonal) {
        Product product = createBaseProduct(type, name, price);
        ((Phone)product).setDiagonal(diagonal);
        return product;
    }

    public static Product createProduct(String type, String name, double price, String value) {
        Product product = createBaseProduct(type, name, price);
        switch (type) {
            case "printer" -> ((Printer) product).setFormat(value);
            case "laptop" -> ((Laptop) product).setCpu(value);
            default -> throw new IllegalArgumentException("Invalid type of product: "+type);
        }
        return product;
    }
}
