package student.examples;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        List<Integer> list = new ArrayList<>();
        list.add(-5);
        list.add(5);
        list.add(1);
        list.add(-1);
        System.out.println(calculator.calculateMedium(list));
    }
}
