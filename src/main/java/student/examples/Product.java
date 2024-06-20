package student.examples;

import java.util.Arrays;

public class Product {
    // fixed part
    private String name;
    private Double price;
    // flexible part
    private Attribute[] attributes;

    private Product() {}
    // product builder
    public static class ProductBuilder {
        // fixed part
        private String name;
        private Double price;
        // flexible part
        private PhysicalDimension height;
        private PhysicalDimension width;
        private PhysicalDimension length;
        private PhysicalDimension weight;

        public ProductBuilder(String name, Double price) {
            this.name = name;
            this.price = price;
        }
        //
        public ProductBuilder withDimension(Double height, Double width, Double length, String unit) {
            this.height = new PhysicalDimension(height, unit);
            this.width = new PhysicalDimension(width, unit);
            this.length = new PhysicalDimension(length, unit);

            return this;
        }

        public ProductBuilder withWeight(Double weight, String unit) {
            this.weight = new PhysicalDimension(weight, unit);

            return this;
        }

        // final method
        public Product build() {
            Product product = new Product();
            // fixed part
            product.setName(name);
            product.setPrice(price);
            // flexible part
            product.setAttributes(new Attribute[4]);
            if (width != null) {
                product.getAttributes()[0] = new Attribute("width", width);
            } if (height != null) {
                product.getAttributes()[1] = new Attribute("height", height);
            } if (length != null) {
                product.getAttributes()[2] = new Attribute("length", length);
            } if (weight != null) {
                product.getAttributes()[3] = new Attribute("weight", weight);
            }
            return product;
        }
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Attribute[] getAttributes() {
        return attributes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAttributes(Attribute[] attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Product name=" + name + ", price=" + price +
                ", attributes=\n" + Arrays.toString(attributes) + "\n";
    }
}
