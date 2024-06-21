package student.examples;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
}

class DataCollection {
    private Object[] data;
    // singleton instance access
    private static DataCollection instance;
    // bloc constructor from external
    private DataCollection() {}
    // getter that return unical instance if exist or create it if it not exist
    public static DataCollection getInstance() {
        if (instance == null) {
            instance = new DataCollection();
        }
        return instance;
    }

    public void add (Object object) {
        if (data == null) {
            data = new Object[1];
        } else {
            data = Arrays.copyOf(data, data.length + 1);
        }
        data[data.length-1] = object;
    }

    public void remove (int index) {
        data[index] = null;
        for (int i =0; i<data.length-1;i++) {
            if (data[i] == null) {

            }
        }
    }

    public Object get(int index) {
        return data[index];
    }
}
