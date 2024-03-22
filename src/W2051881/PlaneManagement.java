package W2051881;
import java.util.Scanner;

public class PlaneManagement {
    //Declare variables used throughout the application
    public static int option,row,column;
    public static int seats[][] = new int[4][];
    public static Ticket[][] ticket_array = new Ticket[4][];
    public static String user_row;

    public static void main(String[] arg){
        // Initialize seating arrangement for the plane
        seats[0] = new int[14]; // Row A with 14 seats
        seats[1] = new int[12]; // Row B with 12 seats
        seats[2] = new int[12]; // Row C with 12 seats
        seats[3] = new int[14]; // Row D with 14 seats

        ticket_array[0] = new Ticket[14];
        ticket_array[1] = new Ticket[12];
        ticket_array[2] = new Ticket[12];
        ticket_array[3] = new Ticket[14];
    while (true) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Welcome to the Plane Management application");
        System.out.println("""
                   *********************************************
                                    MENU OPTIONS           
                   *********************************************
                        0) Quite
                        1) Buy a seat 
                        2) Cancel a seat 
                        3) Find first available seat 
                        4) Show seating plane 
                        5) Print tickets information and total sales 
                        6) search ticket
                   *********************************************
                        """);
        boolean ex;
        do {
            System.out.print("Please select an option : ");
            String input = obj.nextLine();
            if (isValidInteger(input)) {
                PlaneManagement.option = Integer.parseInt(input);
                if (0 <= option && option <= 6) {
                    ex = false;
                } else {
                    System.out.println("Please enter a number between 0 and 6.");
                    ex = true;
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 0 and 6.");
                ex = true;
            }
        }
        while (ex);
            switch (option) {
                case 0:
                    System.out.println("Exiting ...");
                    return;
                case 1:
                    buy_seat();
                    break;
                case 2:
                    cancel_a_seat();
                    break;
                case 3:
                    find_first_available();
                    break;
                case 4:
                    show_seating_plane();
                    break;
                case 5:
                    print_tickets_info();
                    break;
                case 6:
                    search_tickets();
                    break;
            }
        }
    }

    /**
     * Function to validate user input as an integer
     * @param input user input
     * @return true or false
     */
    public static boolean isValidInteger(String input){
        try {
            //try to convert user input to integer
            Integer.parseInt(input);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    // Function to validate user input for seat row (A, B, C, or D)
    public static void seat_number_validate(){
        Scanner obj = new Scanner(System.in);
        do {
            System.out.print("Enter a row : ");
            PlaneManagement.user_row = obj.nextLine(); // Convert input to uppercase for case-insensitive comparison
                if (user_row.equalsIgnoreCase("a")) {
                    PlaneManagement.row = 0;
                break;
            } else if (user_row.equalsIgnoreCase("b")) {
                PlaneManagement.row = 1;
                break;
            } else if (user_row.equalsIgnoreCase("c")) {
                PlaneManagement.row = 2;
                break;
            } else if (user_row.equalsIgnoreCase("d")) {
                PlaneManagement.row = 3;
                break;
            } else {
                System.out.println("Wrong input");
            }
        }while (true);
        do {
            System.out.print("Enter column number : ");
            String input_column = obj.nextLine();
            // Validate user input as an integer
            if (isValidInteger(input_column)) {
                PlaneManagement.column = Integer.parseInt(input_column);
                if (row == 1 || row == 2) {
                    if (column - 1 >= 0 && column - 1 <= 11) {
                        break;
                    } else {
                        System.out.println("Wrong input , Enter seat number between 1 and 12");
                    }
                } else {
                    if (column - 1 >= 0 && column - 1 <= 13) {
                        break;
                    } else {
                        System.out.println("Wrong input , Enter seat number between 1 and 14");
                    }
                }
            }else {
                System.out.println("Wrong input");
            }
        }while (true);
    }
    //checking seat is available or not
    public static boolean seat_is_available(){
        if (seats[row][column-1]==0){
            return true;
        }else {
            return false;
        }
    }

    //buying seat method
    public static void buy_seat(){
        seat_number_validate();
        if (seat_is_available()) {
            System.out.println("Seat is available");
            PlaneManagement.seats[row][column - 1] = 1;  //changing value in seat array
            //creating object for get user inputs
            Scanner obj = new Scanner(System.in);
            //creating variables to collect user data
            String name,username,email;
            do {
                System.out.print("Enter name : ");
                name = obj.nextLine();
            }while (name_validation(name));
            System.out.print("Enter Surname : ");
            username = obj.nextLine();
            do{
                System.out.print("Enter email : ");
                email = obj.nextLine();
            }while (!email_validation(email));

            Person.person = new Person(name,username,email);  //storing the data in class objects

            Ticket obj_ticket =  Storing_ticket_data(row,column); // store data in ticket array and return ticket object
            obj_ticket.writing_data_on_file(row,column);
        } else {
            System.out.println("The seat was booked");
        }
    }
    //cancelling seat
    public static void cancel_a_seat(){
            seat_number_validate();
            if(seat_is_available()) {
                System.out.println("Seat was not booked");
            }else {
                seats[row][column-1] = 0;
                delete_ticket_data(row,column);
                System.out.println("seat is canceled");
            }
    }
    //finding first seat index
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
    //converting letter to relevant number
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
    //printing seats plan
    public static void show_seating_plane(){
        System.out.println(" ");
        System.out.print("  ");
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
    //printing ticket information
    public static void print_tickets_info() {
        printing_all_ticket_data();
        int price = 0;
        for (int rows = 0; rows < 4; rows++) {
            for (int coloumns = 0; coloumns < seats[rows].length; coloumns++) {
                if (seats[rows][coloumns] == 1) {
                    if (coloumns <= 4) {
                        price = price + 200;
                    } else if (coloumns <= 8) {
                        price = price + 150;
                    } else {
                        price = price + 180;
                    }
                } else {
                    continue;
                }
            }
        }
        System.out.println("Total price : " + price);
    }
    //searching tickets and printing information
    public static void search_tickets(){
    System.out.println("Enter below details to search seat : ");
        seat_number_validate();
        if (seat_is_available()) {
                System.out.println("This seat is available");
        } else {
                Search_ticket_and_person_data(row,column);
        }
    }

    /**
     * storing data to ticket array
     * @param row - row number
     * @param column - seat number
     * @return ticket - ticket object
     */
    public static Ticket Storing_ticket_data(int row,int column){
        //checking the price according to seat
        int price;
        if (column<=5){
            price = 200;
        } else if (column>5 && column<=9) {
            price = 150;
        }else {
            price = 180;
        }
        // assigning object and values into ticket object
        Ticket ticket =new Ticket(row,column,price,Person.person);

        // assigning ticket object into specific element of the array
        ticket_array[row][column-1]=ticket;
        return ticket;
    }

    /**
     * deleting ticket data
     * @param row - row number
     * @param column - seat number
     */
    public static void delete_ticket_data(int row,int column){
        // deleting the data from the array
        ticket_array[row][column-1]=null;
    }

    /**
     * searching data  in the array list and print  it out
     * @param row - row number
     * @param column - seat number
     * @reference - "https://www.youtube.com/results?search_query=card+animation+css"
     */
    public static void Search_ticket_and_person_data(int row,int column ) {
        for (Ticket[] i : ticket_array) {
            for (Ticket obj : i) {
                if (obj != null) {
                    if (obj.getRow() == row && obj.getSeat() == column) {
                        System.out.println("Seat : " + PlaneManagement.row_number_to_row_letter(obj.getRow()) + obj.getSeat());
                        System.out.println("Price for ticket : " + obj.getPrice());
                        System.out.println("Your name is : " + obj.getPerson().getName());
                        System.out.println("Your Surname is : " + obj.getPerson().getUsername());
                        System.out.println("Your email is : " + obj.getPerson().getEmail());
                        return;
                    }
                } else {
                    continue;
                }
            }
        }
    }

    /**
     * printing all the tickets with data
     */
    public static void printing_all_ticket_data() {
        int num = 0;
        for (Ticket[] i : PlaneManagement.ticket_array) {
            for (Ticket obj : i) {
                if (obj != null) {
                    num++;
                    System.out.println("Ticket : " + num);
                    obj.printing_ticket_data();
                } else {
                    continue;
                }
            }
        }
    }

    /**
     * validation user entered name is validate or not
     * @param name = user entered name
     * @return  true or false
     * code reference = "https://stackoverflow.com/questions/14599392/identify-valid-characters-of-a-character-array"
     */
    public static boolean name_validation(String name){
        for (char c : name.toCharArray()){
            if (!Character.isLetter(c)&&!Character.isWhitespace(c)){
                System.out.println("invalid name.");
                return true;
            }
        }return false;
    }

    /**
     * validation user entered email is validate or not
     * @param email = user entered email
     * @return true or false
     * @reference = "https://stackoverflow.com/questions/8204680/java-regex-email"
     */
    public static boolean email_validation(String email){
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        boolean validation = email.matches(regex);
        if(!validation){
            System.out.println("Invalid email.");
        }
        return validation;
    }
}