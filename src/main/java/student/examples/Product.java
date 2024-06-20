package student.examples;

public class Product {
    // fixed part
    private String name;
    private Double price;
    //
    private Attribute[] attributes;
    // product builder
    public static class ProductBuilder {
        // fixed part
        private String name;
        private Double price;

        public ProductBuilder(String name, Double price) {
            this.name = name;
            this.price = price;
        }
    }

}
