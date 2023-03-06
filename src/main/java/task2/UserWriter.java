package task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class UserWriter {
    private final OutputStream os;
    private final List<User> users;

    public UserWriter(OutputStream os, List<User> users) {
        this.os = os;
        this.users = users;
    }

    public void writeUsers() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        os.write(gson.toJson(users).getBytes());
        os.close();
    }
}
