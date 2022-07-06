import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Register {

    private static final List<String> menu = new ArrayList<>();
    private static final List<Double> prices = new ArrayList<>();

    private static final List<Food> foodList = new ArrayList<>();

    Register() throws Exception{
        Reader.ReadMenu(menu);
        Reader.ReadPrice(prices);
        //Reader.CreateFood(menu, prices, foodList);
    };

    public void Order(int input, int amount) {
        Order.AddItem(input, amount, menu, prices);
    }

    public void DisplayMenu() {
        System.out.println(Main.DivideLineWithText("MENU"));
        for(int i = 0; i < menu.size(); i++) {
            System.out.printf("%-1d. %-25s %-20.2f%n", i, menu.get(i), prices.get(i));
        }
        System.out.println(Main.DivideLine());
    }

    public static void DisplayList(List<Food> orderList) {
        int count = 0;
        while(count < orderList.size()) {
            System.out.printf("%-25s%-20d%-6.2f%n" ,orderList.get(count).getName(), orderList.get(count).getAmount(), orderList.get(count).getPrice());
            count++;
        }
    }

    public static int getMenuSize() {
        return menu.size();
    }
}