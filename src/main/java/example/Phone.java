package example;

public class Phone extends Product{
    private String name;
    private Double price;

    private int diagonal;

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", diagonal=" + diagonal +
                '}';
    }
}
