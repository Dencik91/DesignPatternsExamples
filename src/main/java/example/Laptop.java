package example;

public class Laptop extends Product{
    private String name;
    private Double price;

    private String cpu;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", cpu='" + cpu + '\'' +
                '}';
    }
}
