package Task3.Filehandling;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Contact{
    String name ;
    String phno;


    Contact(String name , String phno){
        this.name=name;
        this.phno=phno;
    }


    @Override
    public String toString(){
        return name+" - "+phno;
    }

}

public class Contacttask {

    static ArrayList<Contact>contacts = new ArrayList<>();
    static final String fileName = "contact.txt";//the file name should not change so final keyword is used

    static void main() {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("\n 1. Add contact");
            System.out.println(" 2. Search contact by Name");
            System.out.println(" 3. Exit");
            System.out.println("Choose option : ");

            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Adding Contact");
                    System.out.println("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Mobile Number: ");
                    String mono = sc.nextLine();

                    contacts.add(new Contact(name,mono));
                    saveContact();
                    System.out.println("Contact Saved");
                    break;
                case 2:
                    System.out.println("Enter the name to search : ");
                    String searchName = sc.nextLine();
//                    search method
                    searchContact(searchName);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    static void loadAllContact(){
        File file = new File(fileName);
        if (!file.exists()){
            return;
        }
        System.out.println("saved Contacts : ");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line ;
            while ((line = br.readLine() )!= null){
                String [] data = line.split(",");
                Contact c = new Contact(data[0],data[1]);
                contacts.add(c);
                System.out.println(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void saveContact (){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
            for (Contact c : contacts){
                bw.write(c.name+","+c.phno);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void searchContact(String name){
        boolean found = false;
        for (Contact c : contacts){
            if (c.name.equalsIgnoreCase(name)){
                System.out.println("Found ; "+c);
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("Contact not found");
        }
    }
}
