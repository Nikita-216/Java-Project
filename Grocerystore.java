import java.util.Scanner;

// Product Class (OOP - Encapsulation)
class Product {
    int id;
    String name;
    int price;

    Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void show() {
        System.out.println(id + "  " + name + "  Rs." + price);
    }
}

// Store Class (OOP)
class Store {
    Product[] products;

    Store() {
        // Sample grocery items
        products = new Product[4];
        products[0] = new Product(1, "Rice", 50);
        products[2] = new Product(3, "Milk", 30);
        products[1] = new Product(2, "Sugar", 40);
        products[3] = new Product(4, "Bread", 25);
    }

    void showProducts() {
        System.out.println("\n--- Available Products ---");
        for (Product p : products) {
            p.show();
        }
    }

    // Get product by id
    Product getProduct(int id) {
        for (Product p : products) {
            if (p.id == id)
                return p;
        }
        return null;
    }
}

// Cart Class
class Cart {
    int total = 0;

    void add(Product p) {
        total += p.price;
        System.out.println(p.name + " added to cart.");
    }

    void showBill() {
        System.out.println("\nTotal Bill = Rs." + total);
    }
}

// Main Program
public class Grocerystore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Store store = new Store();
        Cart cart = new Cart();

        int choice;

        do {
            System.out.println("\n== Grocery Store ==");
            System.out.println("1. Show Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. Show Bill");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    store.showProducts();
                    break;

                case 2:
                    System.out.print("Enter product ID: ");
                    int id = sc.nextInt();

                    Product p = store.getProduct(id);

                    if (p != null)
                        cart.add(p);
                    else
                        System.out.println("Product not found!");
                    break;

                case 3:
                    cart.showBill();
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        } while (choice != 4);

        sc.close();
    }
}
