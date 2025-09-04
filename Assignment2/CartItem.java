package FoodDeliveryApp.Level2;

//5. Shopping Cart Simulation
public class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double calculateTotalCost() {
        return price * quantity;
    }

    public void displayDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + calculateTotalCost());
    }

    public static void main(String[] args) {
        CartItem item1 = new CartItem("Laptop", 55000, 2);
        item1.displayDetails();
    }
}
