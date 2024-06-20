package student.examples;

public class PhysicalDimension {
    private double value;
    private String unit;

    public PhysicalDimension(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "PhysicalDimension value=" + value + ", unit=" + unit;
    }
}
