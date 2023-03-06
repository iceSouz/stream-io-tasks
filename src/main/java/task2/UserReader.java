package task2;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserReader {
    private final InputStream is;
    private final List<User> users;
    private List<String> dataFromFile = new ArrayList<>();

    public UserReader(InputStream is) {
        this.is = is;
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() throws IOException {
        readDataFromFile();

        if (dataFromFile.size() > 0) {
            Pattern pattern = Pattern.compile("^\\d+$");
            Matcher matcher;
            for (int i = 0; i < dataFromFile.size(); i++) {
                matcher = pattern.matcher(dataFromFile.get(i));
                if (matcher.matches()) {
                    User user = new User(dataFromFile.get(i - 1), Integer.parseInt(dataFromFile.get(i)));
                    users.add(user);
                }
            }
        }

        return users;
    }

    private List<String> readDataFromFile() throws IOException {
        Scanner scanner = new Scanner(is);
        while (scanner.hasNext()) {
            dataFromFile.add(scanner.next());
        }

        is.close();
        scanner.close();

        return dataFromFile;
    }
}
