import java.util.Scanner;
public class Person {
    private String name , username , email;

    public Person() {
        name = "null";
        username = "nuluser";
        email = "nullemail";
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
    public  static void main(String []arg){
        Scanner obj = new Scanner(System.in);
        String name,username,email;
        System.out.print("Enter name");
        name = obj.nextLine();
        System.out.print("Enter username");
        username = obj.nextLine();
        System.out.print("Enter email");
        email = obj.nextLine();
        Person person = new Person();
        person.setEmail(email);
        person.setName(name);
        person.setUsername(username);
        System.out.println(person.getName());
        System.out.println(person.getEmail());
        System.out.println(person.getUsername());
    }
}
