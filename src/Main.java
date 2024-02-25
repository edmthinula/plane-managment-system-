import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static int option =0;
    public static int seats[][] = new int[4][];

    public static void main(String[] args) {
        seats[0] = new int[14];
        seats[1] = new int[12];
        seats[2] = new int[12];
        seats[3] = new int[14];

        //buy_seat();

//        for(int[] rows : seats){
//            System.out.println(Arrays.toString(rows));
//        }

        main_menu();

    }
    public static void main_menu(){
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

                String input = obj.nextLine();

                if (isValidInteger(input)) {
                    Main.option = Integer.parseInt(input);
                    if (0 <= option && option <= 6) {
                        System.out.println("if eke athulata aawa");
                        ex = false;
                    } else {
                        System.out.println("Please enter a number between 1 and 6.");
                        ex = true;
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 6.");
                    ex = true;
                }


        }
        while (ex);
        System.out.println(option);
        switch (option){
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 4:
                System.out.println(4);
                break;
            case 5:
                System.out.println(5);
                break;
            case 6:
                System.out.println(6);
                break;
            case 0:
                System.out.println(0);
                break;
        }
    }
    public static boolean isValidInteger(String input){
        try {
            Integer.parseInt(input);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
//    public static int[][] array_seats(){
//        int seats[][] = new int[4][];
//        seats[0] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0};
//        seats[1] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        seats[2] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0};
//        seats[3] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        return seats;
//    }
    public static void buy_seat(){
        int row , column;
        row = 2;
        column = 12;
        if(row-1<=3 && row-1 >=0) {
            if (row - 1 == 1 || row - 1 == 2) {
                if (column - 1 >= 0 && column - 1 <= 11) {
                    System.out.println("coloumn rows hari");
                    Main.seats[row-1][column-1]= 1;
                } else {
                    System.out.println("2,3 rows wala columns waradi");
                }
            } else {
                if (column - 1 >= 0 && column - 1 <= 13) {
                    System.out.println("coloumn rows hari");
                } else {
                    System.out.println("1,4 rows wala columns waradi");
                }
            }
        }else {
            System.out.println("Rows waradi");
        }
    }
}