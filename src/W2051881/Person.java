package W2051881;

import java.util.Scanner;
public class Person {
    //declare private variables
    private String name , username , email;

    public static Person person;
    //creating getters setters and constructors
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
        do {
            System.out.print("Enter name : ");
            name = obj.nextLine();
        }while (name_validation(name));
        System.out.print("Enter username : ");
        username = obj.nextLine();
        do{
            System.out.print("Enter email : ");
            email = obj.nextLine();
        }while (!email_validation(email));
        //storing the data in class objects
        Person.person = new Person(name,username,email);

    }
    
    public static void printing_person_data(){
        System.out.println("Your name is : "+person.getName());
        System.out.println("Your username is : "+person.getUsername());
        System.out.println("Your email is : "+person.getEmail());

    }
    //validation user entered name is validate or not
    public static boolean name_validation(String name){
        for (char c : name.toCharArray()){
            if (!Character.isLetter(c)&&!Character.isWhitespace(c)){
                System.out.println("invalid name.");
                return true;
            }
        }return false;
    }

    public static boolean email_validation(String email){
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        boolean validation = email.matches(regex);
        if(!validation){
            System.out.println("Invalid email.");
        }
        return validation;
    }
//    public static void main(String arg[]){
//        Scanner obj = new Scanner(System.in);
//        String name1;
//        do{
//             name1 = obj.nextLine();
//        }while (name_validation(name1));
//    }
    public static void main(String []arg){
//        Scanner obj = new Scanner(System.in);
//           String email;
//           do {
//               email = obj.nextLine();
////               System.out.println(email_validation(email));
//           }while (!email_validation(email));
//        storing_person_data();
    }
}
