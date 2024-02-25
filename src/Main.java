import java.util.Scanner;
public class Main {
    public static int option =0;
    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);
        System.out.println("Welcome to the Plane Management application");
        System.out.println("********************************************");
        System.out.println("              MENU OPTIONS             ");
        System.out.println("********************************************");
        System.out.println("    1) Buy a seat" +
                "\n    2) Cancel a seat" +
                "\n    3) Find first available seat" +
                "\n    4) Show seating plane" +
                "\n    5) Print tickets information and total sales" +
                "\n    6) search ticket" +
                "\n    7) Quit");
        System.out.println("*******************************************");
        boolean ex;
        do{
            System.out.println("Please select an option : ");
            try {
                Main.option = obj.nextInt();
                if (0 <= option && option <= 6) {
                    System.out.println("if eke athulata aawa");
                    break;
                } else {
                    System.out.println("else ake inne");
                     ex = true;
                }
            } catch (Exception e) {
                System.out.println("Wrong input");
                 ex = true;
            }
        }
        while (ex);
        System.out.println(option);

    }
}