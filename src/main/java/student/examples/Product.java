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
            if (width != null) {
                addAttribute(product, new Attribute("width", width));
            }
            if (height != null) {
                addAttribute(product, new Attribute("height", height));
            }
            if (length != null) {
                addAttribute(product, new Attribute("length", length));
            }
            if (weight != null) {
                addAttribute(product, new Attribute("weight", weight));
            }
            return product;
        }

        private void addAttribute(Product product, Attribute attribute) {
            if(product.getAttributes() == null) {
                product.setAttributes(new Attribute[1]);
            } else {
                product.setAttributes(Arrays.copyOf(
                        product.getAttributes(), product.getAttributes().length +1));
            }
            product.getAttributes()[product.getAttributes().length-1] = attribute;
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
