import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Reader {

    public Reader() throws Exception {
        FileReader();
    }

    final static String FILE_PATH = "C:\\Users\\zain1\\eclipse-workspace\\Receipt\\Shop";
    final static File file = new File(FILE_PATH);

    final static String FILE_MENU_PATH = "C:\\Users\\zain1\\eclipse-workspace\\Receipt\\Menu";

    final static File file_Menu = new File(FILE_MENU_PATH);

    final static String FILE_PRICE_PATH = "C:\\Users\\zain1\\eclipse-workspace\\Receipt\\Prices";

    final static File file_Price = new File(FILE_PRICE_PATH);
    static String shop_Name, shop_Address, shop_Location, shop_Number;

    private static void FileReader() throws Exception{
        Scanner sc = new Scanner(file);
        while(sc.hasNext()) {
            shop_Name = sc.nextLine();
            shop_Address = sc.nextLine();
            shop_Location = sc.nextLine();
            shop_Number = sc.nextLine();
        }
    }

    public static void ReadMenu(List<String> menu) throws  Exception{
        Scanner sc = new Scanner(file_Menu);
        while(sc.hasNext()) {
            menu.add(sc.nextLine());
        }
    }

    public static void CreateFood(List<String> menu, List<Double> prices, List<Food> foodList){
        int count = 0;
        while(count < menu.size() && count < prices.size()) {
            foodList.add(new Food(0, menu.get(count), prices.get(count)));
            count++;
        }
    }

    public static void ReadPrice(List<Double> prices) throws Exception{
        Scanner sc = new Scanner(file_Price);
        while (sc.hasNext()) {
            prices.add(sc.nextDouble());
        }
    }

    public String getAddress() {
        return shop_Address;
    }

    public String getName() {
        return shop_Name;
    }

    public String getLocation() {
        return shop_Location;
    }

    public String getNumber() {
        return shop_Number;
    }
}
