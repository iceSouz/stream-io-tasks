import task1.NumberParser;
import task2.UserReader;
import task2.UserWriter;
import task3.Reader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // task1
        NumberParser numberParser = new NumberParser(new FileInputStream("src/main/java/task1/file.txt"));
        numberParser.printValidNumbers();


        //task2
        UserReader userReader = new UserReader(new FileInputStream("src/main/java/task2/file.txt"));
        UserWriter userWriter = new UserWriter(
                new FileOutputStream("src/main/java/task2/file.json"),
                userReader.getUsers()
        );
        userWriter.writeUsers();

        System.out.println("======================================");

        //task3
        Reader reader = new Reader(new FileInputStream("src/main/java/task3/words.txt"));
        reader.printWords();
    }
}