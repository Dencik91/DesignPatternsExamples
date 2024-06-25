package example;

public class Printer extends Product{
    private String name;
    private Double price;

    private String format;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Printer{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", format='" + format + '\'' +
                '}';
    }
}
