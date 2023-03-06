package task1;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberParser {
    private final InputStream is;
    private final List<String> listNumbers;

    public NumberParser(InputStream is) {
        this.is = is;
        listNumbers = new ArrayList<>();
    }

    public void printValidNumbers() throws IOException {
        readNumbers();

        if (listNumbers.size() == 0) {
            System.out.println("No valid numbers found!");
        } else {
            for (String number: listNumbers) {
                System.out.println(number);
            }
        }
    }

    private void readNumbers() throws IOException {
        Scanner scanner = new Scanner(is);

        while (scanner.hasNext()) {
            checkValidNumber(scanner.nextLine());
        }

        is.close();
        scanner.close();
    }

    private List<String> checkValidNumber(String number) {
        Pattern pattern = Pattern.compile("^\\(\\d{3}\\) \\d{3}-\\d{4}$|^\\d{3}-\\d{3}-\\d{4}$");
        Matcher matcher = pattern.matcher(number);

        if (matcher.find()) {
            listNumbers.add(matcher.group());
        }

        return listNumbers;
    }
}
