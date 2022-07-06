import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static final int divideLineCount = 50;
    private static final double tax = .08;

    public static void main(String[] args) throws Exception{
        Register reg = new Register();
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int input = 0;
        int amount = 0;
        reg.DisplayMenu();
        while(input != -1) {
            System.out.println("What do you wanna order?");
            input = sc.nextInt();
            if(input != -1){
                System.out.println("How many would you like to order?");
                amount = sc.nextInt();
            }
            if(input != -1) {
                reg.Order(input, amount);
            }
            //Order.AddItem(input, amount, count);
            count++;
        }
        System.out.println("\n\n\n");
        PrintReceipt();
    }

    static void PrintReceipt() throws Exception {
        System.out.println(DivideLineWithText("RECEIPT"));
        System.out.println(PrintShopInfo());
        System.out.println(DivideLineWithText("ORDER"));
        System.out.printf("%-25s%-20s%-20s\n", "ITEM", "AMOUNT", "PRICE");
        Order.DisplayList();
        System.out.println(DivideLineWithText("TOTAL"));
        FormattedString("SUB-TOTAL", Order.GetSubTotal());
        FormattedString("Tax", tax);
        FormattedString("Total", Order.GetOrderTotal(tax));
        System.out.println(DivideLineWithText("END"));
    }

    static String PrintShopInfo()throws Exception {
        Reader r = new Reader();
        return CenterLineWithText(r.getName()) + "\n" + CenterLineWithText(r.getAddress()) + "\n" + CenterLineWithText(r.getLocation()) + "\n" + CenterLineWithText(r.getNumber());
    }

    static String DivideLine() {
        return "-".repeat(divideLineCount);
    }

    static String DivideLineWithText(String text) {
        int lineCut = (divideLineCount - text.length()) / 2;
        if(text.length() % 2 != 0) return "-".repeat(lineCut + 1) + text + "-".repeat(lineCut);
        return "-".repeat(lineCut) + text + "-".repeat(lineCut);
    }

    static String CenterLineWithText(String text) {
        int lineCut = (divideLineCount - text.length()) / 2;
        if(text.length() % 2 != 0) return " ".repeat(lineCut + 1) + text;
        return " ".repeat(lineCut) + text;
    }

    static void FormattedString(String text, double price) {
        System.out.printf("%-10s: %-,10.2f%n", text, price);
    }

    static void Void() {
        System.out.println("Which would you like to void?");
        Order.DisplayList();
    }
}
