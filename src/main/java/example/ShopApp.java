package example;

public class ShopApp {
    public static void main(String[] args) {
        Product smartPhone = ProductFactory.createProduct(
                "phone", "Xiaomi", 100.00, 6);
        Product inkPrinter = ProductFactory.createProduct(
                "printer", "Epson", 300.00, "A4");
        System.out.println(smartPhone);
        System.out.println(inkPrinter);
    }
}
