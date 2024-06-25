package example;

public class ShopApp {
    public static void main(String[] args) {
        Product smartPhone = ProductFactory.createProduct(
                "phone", "Xiaomi", 100.00, 6);
        Product inkPrinter = ProductFactory.createProduct(
                "printer", "Epson", 300.00, "A4");
        Product smallLaptop = ProductFactory.createProduct(
                "laptop", "Dell", 700.00, "Intel");
        System.out.println(smartPhone);
        System.out.println(inkPrinter);
        System.out.println(smallLaptop);
    }

    // TODO try to set constructor in default classto simplify the factory
}
