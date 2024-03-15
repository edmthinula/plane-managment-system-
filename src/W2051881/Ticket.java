package W2051881;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ticket {
    //declare  private variables
    private int row;
    private int seat;
    private int price;
    Person person;
    public static Ticket ticket;
    public static Ticket[][] ticket_array = new Ticket[4][];
    //creating getters setters and constructor
    public Ticket(int row, int seat, int price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public static void Storing_ticket_data(int row,int coloumn){
     //checking the price according to seat
        int price;
        if (coloumn<=5){
            price = 200;
        } else if (coloumn>5 && coloumn<=9) {
            price = 150;
        }else {
            price = 180;
        }
        // assigning object and values into ticket object
        Ticket.ticket =new Ticket(row,coloumn,price,Person.person);

        // assigning ticket object into specific element of the array
        Ticket.ticket_array[row][coloumn-1]=ticket;

    }
    public static void printing_ticket_data(){
        System.out.println("Your row is : "+ W2051881__PlaneManagement.row_number_to_row_letter(W2051881__PlaneManagement.row));
        System.out.println("Your Seat is : "+ticket.getSeat());
        System.out.println("Your Price is : "+ticket.getPrice());
    }

    public static void delete_ticket_data(int row,int coloumn){
        // deleting the data from the array
        Ticket.ticket_array[row][coloumn-1]=null;

    }
    //printing all the tickets with data
    public static void printing_all_ticket_data(){
        int num = 0 ;
        for(Ticket[] i : Ticket.ticket_array){
            for(Ticket obj : i){
                if (obj!= null) {
                    num++;
                    System.out.println("Ticket : "+num);
                    System.out.println("Seat : "+ W2051881__PlaneManagement.row_number_to_row_letter(obj.getRow())+ obj.getSeat());
                    System.out.println("Price for ticket : "+obj.getPrice());
                    System.out.println("Your name is : "+obj.getPerson().getName());
                    System.out.println("Your username is : "+obj.getPerson().getUsername());
                    System.out.println("Your email is : "+obj.getPerson().getEmail());
                }else {
                    continue;
                }
            }
        }
    }
    //searching data  in the array list and print  it out
    public static void Search_ticket_and_person_data(int row,int coloumn ){
        for(Ticket[] i : Ticket.ticket_array){
            for(Ticket obj : i){
                if (obj!= null) {
                 if(obj.getRow()==row && obj.getSeat()==coloumn) {
                     System.out.println("Seat : " + W2051881__PlaneManagement.row_number_to_row_letter(obj.getRow()) + obj.getSeat());
                     System.out.println("Price for ticket : " + obj.getPrice());
                     System.out.println("Your name is : " + obj.getPerson().getName());
                     System.out.println("Your username is : " + obj.getPerson().getUsername());
                     System.out.println("Your email is : " + obj.getPerson().getEmail());
                     return;
                 }
                }else {
                    continue;
                }
            }
        }

    }
    //creating file , name it as seat name
    public static  void file_handling(int row,int column){
        try{
            String name_for_file = W2051881__PlaneManagement.row_number_to_row_letter(row)+column+".txt";
            File file = new File(name_for_file);
            boolean chacking = file.exists();
            if(chacking != true){
                boolean file_created = file.createNewFile();
                if(file_created){
                    System.out.println("file was created "+file.getName());
                }else{
                    System.out.println("Error while file creating :" +file.getName());
                }
            }else {
                System.out.println("file was already created "+file.getName());
            }
        }catch (IOException e){
            System.out.println("Exception occured: " +e);
            e.printStackTrace();
        }
    }
    //write data to the files
    public static void writing_data_on_file(int row,int column) {
        try {
            String name_for_file = W2051881__PlaneManagement.row_number_to_row_letter(row) + column + ".txt";
            File file = new File(name_for_file);
            if (file.exists() && file.canWrite()) {
                FileWriter fw = new FileWriter(name_for_file);
                fw.write("\nSeat is : "+ W2051881__PlaneManagement.row_number_to_row_letter(W2051881__PlaneManagement.row)+ticket.getSeat());
                fw.write("\nPrice is : "+ticket.getPrice());
                fw.write("\nName is : "+Person.person.getName());
                fw.write("\nUsername is : "+Person.person.getUsername());
                fw.write("\nYour email is : "+Person.person.getEmail());
                fw.close();
            } else {
                System.out.println("File doesn't exists or can't write.");
            }
        } catch (IOException e) {
            System.out.println("Exception occur : " + e);
            e.printStackTrace();
        }
    }
}
