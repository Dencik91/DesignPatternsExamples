package student.examples;

import java.util.List;

public class Calculator {
    int medium;

    public int calculateMedium(List<Integer> list) {
        for(int number : list) {
            medium += number;
        }
        return medium = (int)Math.round(((double)medium)/list.size());
    }
}
