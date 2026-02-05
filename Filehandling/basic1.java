package Task3.Filehandling;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class basic1 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        String filename = "notes.txt";
        System.out.println("Enter the line and once you are done then type Exit to finish");
// taking multi line inputs
        StringBuilder notes = new StringBuilder();
        while (true) {
            String lines = sc.nextLine();
            if (lines.trim().equalsIgnoreCase("exit")) break;
            notes.append(lines).append(System.lineSeparator()); // it separates or puts the line on new line  basically formats the lines provided
        }
//        saving the file
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(notes.toString());
            System.out.println("Notes SAVED TO : "+filename);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

//        reading the file content

        try {
            String content = Files.readString(Path.of(filename));
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("Error reading the file : "+ e.getMessage());
        }
    }
}
