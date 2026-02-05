package Task3.Filehandling;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copy {
    static void main() {
        String ogfile = "src.txt"; // any filename you want to copy data from
        String replica = "copies.txt";// file you want to copy data to

        try {
            FileReader reader = new FileReader(ogfile);
            FileWriter writer = new FileWriter(replica);
            int ch ;
            while (( ch = reader.read() )!= -1){
                writer.write(ch);
            }
            System.out.println("Filed copied successfully!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
