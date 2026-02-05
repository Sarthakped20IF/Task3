package Task3.Filehandling;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Task 9 : Student Record System
//Requirements:
//Use a HashMap<String, Integer> to store student name → marks.
//Allow user to:
//Add a student record
//View all records
//Save all records to a file (students.txt)
//Read records from file and display them
public class StudentRecordSystem {
    static final String fileName = "students.txt";
    static HashMap<String,Integer>records = new HashMap<>();
    static void main() {
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("\n---- STUDENT RECORD SYSTEM ----");
            System.out.println("1. Add Student Record");
            System.out.println("2. View All Records");
            System.out.println("3. Save Records to File");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice= sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Add Student:");
                    addRecord(sc);
                    break;

                case 2:
                    System.out.println("Fetching all Records...");
                    viewAll();
                    break;
                case 3:
                    saveAll();
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    static void addRecord (Scanner sc){
        String name = sc.nextLine().trim();
        String marksStr = sc.next();

        int marks;
        try {
            marks = Integer.parseInt(marksStr);
        } catch (NumberFormatException e) {
            e.getMessage();
            return;
        }
        if (marks < 0 || marks > 100) {
            System.out.println("Invalid Marks entered");
            return;
        }
        if (marks <0 || marks>100){
            System.out.println("invalid marks entered");
            return;
        }
        records.put(name,marks);
        System.out.println("Studend added ! ");
    }
    static void viewAll (){
        if (records.isEmpty()){
            System.out.println("No records Found");
            return;
        }
        System.out.println("Student Records :");
        for (Map.Entry<String,Integer>entry:records.entrySet()){
            System.out.println("Student name: "+entry.getKey()+" Marks : "+entry.getValue());
        }
    }
    static void saveAll (){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String,Integer>entry:records.entrySet()){
                bw.write(entry.getKey()+","+entry.getValue());
                bw.newLine();
            }
            System.out.println("Records Saved in file"+fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void loadRecords(){
        File file = new File(fileName);
        if (!file.exists()){
            System.out.println("File Not Found");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line ;
            while ((line = br.readLine())!=null){
                if (line.trim().isEmpty())continue;

                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    try {
                        int marks = Integer.parseInt(parts[1].trim());
                        records.put(name, marks);
                    } catch (NumberFormatException e) {
                        e.getMessage();
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
