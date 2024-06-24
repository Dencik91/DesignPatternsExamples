package student.examples;

public class App {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.subscribe(new Client("John Doe"));
        shop.subscribe(new Client("Marry Poppins"));

        System.out.println("The shop has next subscribers");
        for (Client client : shop.clients) {
            if (client != null) {
                System.out.println(client.fullName);
            }
        }

        shop.addProduct(new Product("Some smartphone"));
        shop.addProduct(new Product("Eyeglasses"));

        System.out.println("The shop has next products");
        for (Product product : shop.products) {
            if (product != null) {
                System.out.println(product.name);
            }
        }
    }
}

// TODO optimize code on shop class, try to use Object as parameter

// publisher
class Shop {
    public Product[] products = new Product[5];
    public Client[] clients = new Client[10];

    // eCommerce methods
    public void addProduct(Product product) {
        for (int i=0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                break;
            }
        }

        // notify the subscribers
        for (Client client : clients) {
            if (client != null) {
                client.update(product);
            }
        }
    }

    //pub/sub methods
    public void subscribe(Client client) {
        for (int i=0; i < clients.length; i++) {
            if (clients[i] == null) {
                clients[i] = client;
                break;
            }
        }
    }

    public void unsubscribe(int index) {
        for (int i=index; i< clients.length-1; i++) {
            clients[i] = clients[i-1];
        }
    }
}

// event
class Product {
    public String name;

    public Product(String name) {
        this.name = name;
    }
}

// subscribers
class Client {
    public String fullName;

    public Client(String fullName) {
        this.fullName = fullName;
    }

    // subscriber method
    public void update(Product product) {
        System.out.println("Me, "+fullName+", I have decided to buy "+product.name);
    }
}
