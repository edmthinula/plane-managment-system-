package W2051881;

import java.util.Scanner;
public class Person {
    private String name , username , email;

    public static Person person;
    public Person(String name, String username, String email) {
        this.name = name;
        this.username = username;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public  static void storing_person_data(){

        //creating object for get user inputs
        Scanner obj = new Scanner(System.in);

        //creating variables to collect user data
        String name,username,email;

        System.out.print("Enter name ");
        name = obj.nextLine();
        System.out.print("Enter username ");
        username = obj.nextLine();
        System.out.print("Enter email ");
        email = obj.nextLine();
        Person.person = new Person(name,username,email);

    }
    public static void printing_person_data(){
        System.out.println("Your name is : "+person.getName());
        System.out.println("Your username is : "+person.getUsername());
        System.out.println("Your email is : "+person.getEmail());

    }
//    public static void writing_person_data(int row,int column) throws IOException {
//        String name_for_file = Main.row_number_to_row_letter(row) + column + ".txt";
//        File file = new File(name_for_file);
//        FileWriter fw = new FileWriter(name_for_file);
//        fw.write("\nName is : "+person.getName());
//        fw.write("\nUsername is : "+person.getUsername());
//        fw.write("\nYour email is : "+person.getEmail());
//    }
//    public static void main(String []arg){
//        storing_person();
//        printing_person_data();
//
//    }
}
