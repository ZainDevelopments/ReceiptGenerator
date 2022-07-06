public class Food {
    private int amount;
    private final String name;

    private double price;

    public Food() {
        name = "NULL";
        amount = 0;
        price = 0;
    }

    public Food(int amount, String name, double price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public int getAmount() {
        return this.amount;
    }
    
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "Item: " + name + "\nPrice: " + price + "\nAmount: " + amount;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
