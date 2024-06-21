package student.examples;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DataCollection dataCollection = DataCollection.getInstance();
        dataCollection.add(10);
        dataCollection.add(20);
        dataCollection.add(30);

        System.out.println(dataCollection.get(0));
        System.out.println(dataCollection.get(1));
        System.out.println(dataCollection.get(2));
        System.out.println();

        DataCollection dataCollection1 = DataCollection.getInstance();
        dataCollection1.add(40);

        System.out.println(dataCollection1.get(0));
        System.out.println(dataCollection1.get(1));
        System.out.println(dataCollection1.get(2));
        System.out.println(dataCollection1.get(3));
        System.out.println();

        DataCollection dataCollection2 = DataCollection.getInstance();
        dataCollection2.remove(3);

        System.out.println(dataCollection2.get(0));
        System.out.println(dataCollection2.get(1));
        System.out.println(dataCollection2.get(2));
//        System.out.println(dataCollection2.get(3));
        System.out.println();
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
        for (int i =index; i<data.length-1;i++) {
            data[i] = data[i+1];
        }
        data = Arrays.copyOf(data, data.length-1);
    }

    public Object get(int index) {
        return data[index];
    }
}
