package student.examples;

public class Main {
    public static void main(String[] args) {
        Product product = new Product.ProductBuilder("Samsung", 1000.00)
                .withWeight(124.6, "gramms")
                .withDimension(2.5, 0.1, 4.5, "inch")
                .build();
        System.out.println(product);
    }
}
