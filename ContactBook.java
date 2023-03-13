import java.util.Scanner;
import java.util.LinkedList;
import java.util.*;
import java.io.*;

class Person {
    public String Name;
    public String PhoneNum;
    public String Email;

    public Person(String Name, String PhoneNum, String Email) {
        this.Name = Name;
        this.PhoneNum = PhoneNum;
        this.Email = Email;
    }

    public String toString() {
        return Name + " " + PhoneNum + " " + Email;
    }
}
public class Main {
    public static void main(String[] args) {
        LinkedList <Person> contact = new LinkedList<>();
        contact.add(new Person("PATTINSON", "081274562958", "pattinson@gmail.com"));
        contact.add(new Person("ROCKY", "081238560022", "rocky@gmail.com"));
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.println("*****************************");
            System.out.println("(A)dd");
            System.out.println("(D)elete");
            System.out.println("(E)mail search");
            System.out.println("(P)rint List");
            System.out.println("(S)earch");
            System.out.println("(Q)uit");
            System.out.println("*****************************");
            System.out.print("Please enter a command: ");
            String cmd = scn.next();
            scn.nextLine();
            switch (cmd) {
                case "A":
                    System.out.println("Enter new name:");
                    String newName = scn.nextLine().toUpperCase();
                    System.out.println("Enter their phone number:");
                    String newPhoneNum = scn.nextLine();
                    System.out.println("Enter their email:");
                    String newEmail = scn.nextLine();
                    contact.add(new Person(newName, newPhoneNum, newEmail));
                    break;

                case "D":
                    System.out.println("Enter name to remove:");
                    String removeName = scn.nextLine().toUpperCase();

                    boolean objectFoundD = false;

                    for(Person element : contact) {
                        if (removeName.equals(element.Name)){
                            contact.remove(element);
                            objectFoundD = true;
                            break;
                        }
                        else {
                            continue;
                        }
                    }
                    if (objectFoundD == false) {
                        System.out.println("Name not found, the name you are trying to delete does not exist or it is mistyped.");
                    }

                    break;

                case "E":
                    System.out.println("Search for email:");
                    String emailSearch = scn.nextLine();

                    boolean objectFoundE = false;
                    for(Person element : contact) {
                        if (emailSearch.equals(element.Email)) {
                            System.out.println(element.toString());
                            objectFoundE = true;
                            break;
                        }
                        else {
                            continue;
                        }
                    }
                    if (objectFoundE == false) {
                        System.out.println("Email not found, either the email does not exist or you made a typo.");
                    }
                    break;

                case "P":
                    System.out.println("[");
                    for (Person element : contact) {
                        System.out.println(element.toString());
                    }
                    System.out.println("]");
                    break;


                case "S":
                    System.out.println("Search for name:");
                    String nameSearch = scn.nextLine().toUpperCase();
                    boolean objectFoundS = false;

                    for(Person element : contact) {
                        if (nameSearch.equals(element.Name)) {
                            System.out.println(element);
                            objectFoundS = true;
                            break;
                        }
                        else {
                            continue;
                        }
                    }
                    if (objectFoundS == false) {
                        System.out.println("Name not found, either the name does not exist, or you made a typo.");
                    }
                    break;

                case "Q":
                    System.out.println("See you next time!");
                    System.exit(0);
                default:
                    System.out.println("Unknown input, enter proper input.");
            }
        }
    }
}

