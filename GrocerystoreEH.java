import java.util.*;

// Product Class
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

// Store Class
class Store {
    Product[] products;

    Store() {
        products = new Product[4];
        products[0] = new Product(1, "Rice", 50);
        products[1] = new Product(2, "Sugar", 40);
        products[2] = new Product(3, "Milk", 30);
        products[3] = new Product(4, "Bread", 25);
    }

    void showProducts() {
        System.out.println("\n--- Products ---");
        for (Product p : products) {
            p.show();
        }
    }

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
        if (total == 0) {
            System.out.println("\nCart is empty! Add items first.");
        } else {
            System.out.println("\nTotal Bill = Rs." + total);
        }
    }
}

// Main Class
public class GrocerystoreEH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Store store = new Store();
        Cart cart = new Cart();

        int choice = 0;

        do {
            try {
                System.out.println("\n== Grocery Store ==");
                System.out.println("1. Show Products");
                System.out.println("2. Add to Cart");
                System.out.println("3. Show Bill");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");

                choice = sc.nextInt();

                if (choice < 1 || choice > 4) {
                    throw new Exception("Please enter a valid choice (1–4).");
                }

                switch (choice) {
                    case 1:
                        store.showProducts();
                        break;

                    case 2:
                        System.out.print("Enter Product ID: ");
                        int id = sc.nextInt();

                        Product p = store.getProduct(id);
                        if (p != null)
                            cart.add(p);
                        else
                            throw new Exception("Product ID not found.");
                        break;

                    case 3:
                        cart.showBill();
                        break;

                    case 4:
                        System.out.println("Thank you!");
                        break;
                }
            }

            // Wrong input (letters instead of numbers)
            catch (InputMismatchException e) {
                System.out.println("\nError: Please enter numbers only.");
                sc.nextLine(); // clear input
            }

            // Custom errors
            catch (Exception e) {
                System.out.println("\nError: " + e.getMessage());
            }

        } while (choice != 4);

        sc.close();
    }
}
