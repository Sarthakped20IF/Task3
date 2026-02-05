package Task3.Filehandling;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Readncount {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the filename: ");
        String filename = sc.nextLine();

        try {
            String content = Files.readString(Path.of(filename));
            String [] words = content.trim().split("//s+");
            int wordCount = 0;
            if (content.trim().isEmpty()){
                System.out.println(wordCount);
            }else {
                wordCount += words.length;
                System.out.println("Total count of words in the file is : "+wordCount);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
