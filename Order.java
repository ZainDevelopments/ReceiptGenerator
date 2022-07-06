import java.util.ArrayList;
import java.util.List;

public class Order{

    //Food prices
    static double burger_Price = 8.99;
    static double mt_Price = 3.50;
    static double bsmt_Price = 4.99;
    static double pcc_Price = 5.25;
    static Food[] list = new Food[10];

    static List<Food> orderList = new ArrayList<>();

    public static void AddItem(int input, int amount, int count) {
        switch (input) {
            case 1:
                list[count] = new Food(amount, "Burger", burger_Price);
                break;
            case 2:
                list[count] = new Food(amount, "Milk Tea", mt_Price);
                break;
            case 3:
                list[count] = new Food(amount, "Brown Sugar Milk Tea", bsmt_Price);
                break;
            case 4:
                list[count] = new Food(amount, "Popcorn Chicken", pcc_Price);
                break;
        }
    }

    public static void AddItem(int input, int amount, List<String> menu, List<Double> prices) {
        orderList.add(new Food(amount, menu.get(input), prices.get(input)));
    }

    public static void DisplayList() {
        Register.DisplayList(orderList);
    }

    public static double GetSubTotal() {
        double total = 0;
        int count = 0;
        while(count < orderList.size()) {
            total += orderList.get(count).getPrice() * orderList.get(count).getAmount();
            count++;
        }
        return total;
    }

    public static double GetOrderTotal(double tax) {
        double total = 0;
        int count = 0;
        while(count < orderList.size()) {
            total += orderList.get(count).getPrice() * orderList.get(count).getAmount();
            count++;
        }
        double taxTotal = total * tax;
        return total + taxTotal;
    }

    public static double GetOrderTotalWithDiscount(double discount) {
        double total = 0;
        int count = 0;
        while(count < orderList.size()) {
            total += orderList.get(count).getPrice() * orderList.get(count).getAmount();
            count++;
        }
        return total - discount;
    }

    public void VoidItem(int input)
     {
        list[input] = null;
    }
}
