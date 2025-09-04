package FoodDeliveryApp.Level1;

//4. Program to Track Inventory of Items

public class Item {
    private int itemCode;
    private String itemName;
    private double price;

    // Constructor
    public Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Method to calculate total cost
    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    // Method to display item details
    public void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
    }

    // Main method
    public static void main(String[] args) {
        Item item1 = new Item(101, "Laptop", 55000);
        item1.displayDetails();
        System.out.println("Total cost for 2 items: " + item1.calculateTotalCost(2));
    }
}
