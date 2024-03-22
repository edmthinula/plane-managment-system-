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

    public  void printing_ticket_data(){
        System.out.println("Seat is : "+ PlaneManagement.row_number_to_row_letter(PlaneManagement.row)+ seat);
        System.out.println("Your Price is : "+price);
        person.printing_person_data();
    }

    /**
     * write data to the files
     * @param row row number
     * @param column seat number
     *
     */
    public  void writing_data_on_file(int row,int column) {
        try {
            String name_for_file = PlaneManagement.row_number_to_row_letter(row) + column + ".txt";
            File file = new File(name_for_file);

                FileWriter fw = new FileWriter(name_for_file);
                fw.write("\nSeat is        : "+ PlaneManagement.row_number_to_row_letter(PlaneManagement.row)+ seat);
                fw.write("\nPrice is       : "+price);
                fw.write("\nName is        : "+person.getName());
                fw.write("\nSurname is     : "+person.getUsername());
                fw.write("\nYour email is  : "+person.getEmail());
                fw.close();


        } catch (IOException e) {
            System.out.println("Exception occur : " + e);
        }
    }
}
