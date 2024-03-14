package W2051881;
import java.util.Scanner;

public class Main {
    public static int option,row,column;
    public static int seats[][] = new int[4][];
    public static String user_row;

    public static void main(String[] args) {
        seats[0] = new int[14];
        seats[1] = new int[12];
        seats[2] = new int[12];
        seats[3] = new int[14];

        Ticket.ticket_array[0] = new Ticket[14];
        Ticket.ticket_array[1] = new Ticket[12];
        Ticket.ticket_array[2] = new Ticket[12];
        Ticket.ticket_array[3] = new Ticket[14];

//        Main.seats[0][0] = 1;
//        Main.seats[1][4]=1;
//        Main.seats[2][8] =1;
//        Main.seats[3][13]=1;

        //seat_number_validate();
        //buy_seat();
        main_menu();
        //find_first_available();
        //seating_plane();
        //printing_total_price();
    }
    public static void main_menu(){
    while (true) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Welcome to the Plane Management application");
        System.out.println("""
                   *********************************************
                                    MENU OPTIONS             
                   *********************************************
                        1) Buy a seat 
                        2) Cancel a seat 
                        3) Find first available seat 
                        4) Show seating plane 
                        5) Print tickets information and total sales 
                        6) search ticket
                        7) Quit
                   *********************************************
                        """);
        boolean ex;
        do {
            System.out.print("Please select an option : ");
            String input = obj.nextLine();
            if (isValidInteger(input)) {
                Main.option = Integer.parseInt(input);
                if (0 <= option && option <= 6) {
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
        //System.out.println(option);

        switch (option) {
            case 0:
                System.out.println("Exiting System.");
                return;
            case 1:
                //System.out.println(1);
                buy_seat();

                break;
            case 2:
                //System.out.println(2);
                cancel_a_seat();
                break;
            case 3:
                //System.out.println(4);
                find_first_available();
                break;
            case 4:
                //System.out.println(5);
                show_seating_plane();
                break;
            case 5:
                //System.out.println(6);
                print_tickets_info();
                break;
            case 6:
                //System.out.println(0);
                search_tickets();
                break;
        }
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

    public static void seat_number_validate(){
        Scanner obj = new Scanner(System.in);
        do {
            System.out.print("Enter a row : ");
            Main.user_row = obj.nextLine();
            if (user_row.equalsIgnoreCase("a")) {
                Main.row = 0;
                break;
            } else if (user_row.equalsIgnoreCase("b")) {
                Main.row = 1;
                break;
            } else if (user_row.equalsIgnoreCase("c")) {
                Main.row = 2;
                break;
            } else if (user_row.equalsIgnoreCase("d")) {
                Main.row = 3;
                break;
            } else {
                System.out.println("Wrong input");
            }
        }while (true);
        do {
            System.out.print("Enter column number : ");
            String input_column = obj.nextLine();
            if (isValidInteger(input_column)) {
                Main.column = Integer.parseInt(input_column);
                if (row == 1 || row == 2) {
                    if (column - 1 >= 0 && column - 1 <= 11) {
                        System.out.println("column rows hari");
                        // Main.seats[row - 1][column - 1] = 1;
                        break;
                    } else {
                        System.out.println("2,3 rows wala columns waradi");
                    }
                } else {
                    if (column - 1 >= 0 && column - 1 <= 13) {
                        System.out.println("column rows hari");
                        break;
                    } else {
                        System.out.println("1,4 rows wala columns waradi");
                    }
                }
            }else {
                System.out.println("Wrong input");
            }
        }while (true);
    }
    public static boolean seat_is_available(){
        if (seats[row][column-1]==0){
            return true;
        }else {
            return false;
        }
    }
    public static void buy_seat(){
        do {
            seat_number_validate();
            if (seat_is_available()) {
                Main.seats[row][column - 1] = 1;
                Person.storing_person_data();
                Ticket.Storing_ticket_data(row,column);
                Person.printing_person_data();
                Ticket.printing_ticket_data();
                Ticket.file_handling(row,column);
                Ticket.writing_data_on_file(row,column);
//                for (int[] rows : seats) {
//                    System.out.println(Arrays.toString(rows));
//                }
                break;
            } else {
                System.out.println("the seat was booked");
            }
        }while (true);
    }
    public static void cancel_a_seat(){
        do{
            seat_number_validate();
            if(seat_is_available()){
                System.out.println("Seat was not booked");
            }else {
                seats[row][column-1] = 0;
                Ticket.delete_ticket_data(row,column);
                break;
            }
        }while (true);
    }
    public static void find_first_available(){
        int row_index = 0 , column_index = 0;
        for (int rows[]:seats){
            for(int element : rows){
                if(element == 0){
                    System.out.println(row_number_to_row_letter(row_index)+" , "+(column_index +1));
                    return;
                }
                column_index++;
            }
            row_index++;
        }
    }
    public static String row_number_to_row_letter(int num){
        switch (num){
            case 0:
                return "A";
            case 1:
                return "B";
            case 2:
                return "C";
            case 3:
                return "D";
        }
        return null;
    }
    public static void show_seating_plane(){
        for(int count = 1;count<10;count++) {
            System.out.print(count+" |");
        }
        for(int count = 10;count<15;count++) {
            System.out.print(count+"|");
        }System.out.println();
        int row_num = 0;
        for(int[] i:seats) {
            System.out.print(row_number_to_row_letter(row_num)+" ");
            row_num++;
                for (int a : i) {
                    if (a == 1) {
                        System.out.print("X  ");
                    } else {
                        System.out.print(a + "  ");
                    }
                }System.out.println("");
        }System.out.println("");
    }
    public static void print_tickets_info(){
        Ticket.printing_all_ticket_data();
        int price=0;
        for (int rows=0 ; rows<4;rows++){
            for(int coloumns = 0 ; coloumns<seats[rows].length ;coloumns++){
                if (seats[rows][coloumns]==1){
                    if(coloumns<=4){
                        price = price +200;
                    } else if (coloumns<=8) {
                        price = price + 150;
                    }else {
                        price = price + 180;
                    }
                }else {
                    continue;
                }
            }
        }
        System.out.println("Total price : "+price);
    }
    public static void search_tickets(){
    System.out.println("Enter below details to search seat : ");
        seat_number_validate();
        if (seat_is_available()) {
                System.out.println("This seat is available");
        } else {
                Ticket.Search_ticket_and_person_data(row,column);
        }
    }
}