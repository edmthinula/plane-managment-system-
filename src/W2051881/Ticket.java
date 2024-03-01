package W2051881;
;

public class Ticket {
    private int row;
    private int seat;
    private int price;
    Person person;
    public static Ticket ticket;

    public static Ticket[][] ticket_array = new Ticket[4][];
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
            price = 200;
        }
        Ticket.ticket =new Ticket(row,coloumn,price,Person.person);

        ticket_array[0] = new Ticket[14];
        ticket_array[1] = new Ticket[12];
        ticket_array[2] = new Ticket[12];
        ticket_array[3] = new Ticket[14];
        Ticket.ticket_array[2][coloumn-1]=ticket;
//        for(Ticket[] i : Ticket.ticket_array){
//            for(Ticket obj : i){
//                if (obj!= null) {
//                    System.out.println(obj.getRow());
//                    System.out.println(obj.getSeat());
//                    System.out.println(obj.getPrice());
//                    System.out.println(obj.getPerson().getName());
//                    System.out.println(obj.getPerson().getUsername());
//                    System.out.println(obj.getPerson().getEmail());
//                }else {
//                    System.out.print(obj);
//                }
//            }
//        }
    }
    public static void printing_ticket_data(){
        System.out.println("Your row is : "+Main.row_number_to_row_letter(Main.row));
        System.out.println("Your Seat is : "+ticket.getSeat());
        System.out.println("Your Price is : "+ticket.getPrice());
    }
    public static void main(String []arg){
        Person.storing_person_data();
        Ticket.Storing_ticket_data(3,5);
        Person.printing_person_data();
        Ticket.printing_ticket_data();
    }
}
