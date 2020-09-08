package uoft.csc207.gameproject.user;

import android.os.Environment;
import android.util.JsonReader;
import android.util.JsonWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import uoft.csc207.gameproject.GameApplication;

/**
 * the user file class to manager file
 */
class UserFileHandler {
    private static final String FILE_NAME = "Users.json";
    private Map<String, User> users;

    UserFileHandler() {
        users = new HashMap<String, User>();
    }

    /**
     * Getter for user information
     * @return map of users
     */
    Map<String, User> getUsers() {
        return users;
    }

    /**
     * Set user's information
     * @param users new user's information
     */
    void setUsers(Map<String, User> users) {
        this.users = users;
    }

    /**
     * Loads the user information to memory.
     */
    void loadFromFile() {
        try {
            File directory = GameApplication.getInstance().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            File source = new File(directory, FILE_NAME);
            Map<String, User> userMap = new HashMap<String, User>();
            if (source.exists()) {
                JsonReader reader = new JsonReader(new FileReader(source));
                reader.beginArray();
                while (reader.hasNext()) {
                    User user = readUser(reader);
                    userMap.put(user.getUsername(), user);
                }
                reader.endArray();
                reader.close();
            } else {
                source.createNewFile();
            }
            users = userMap;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the user information to file.
     */
    void saveToFile() {
        try {
            File directory = GameApplication.getInstance().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            File target = new File(directory, FILE_NAME);
            if (!target.exists()) {
                target.createNewFile();
            }
            JsonWriter writer = new JsonWriter(new FileWriter(target));
            writer.setIndent("    ");
            writer.beginArray();
            for (User user : users.values()) {
                writeUser(writer, user);
            }
            writer.endArray();
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read the next user from the {@code reader}.
     *
     * @param reader The JsonReader from which the user is loaded.
     * @return The {@link User} loaded from the {@code reader}.
     * @throws IOException
     */
    private User readUser(JsonReader reader) throws IOException {
        String username = null;
        String password = null;
        long snakeSpeed = 200;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("Username")) {
                username = reader.nextString();
            } else if (name.equals("Password")) {
                password = reader.nextString();
            } else if (name.equals("SnakeSpeed")) {
                snakeSpeed = reader.nextLong();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        User user = new User(username, password);
        user.setSnakeSpeed(snakeSpeed);
        return user;
    }

    /**
     * Write {@code user} using the {@code writer}.
     *
     * @param writer The JsonWriter used to write {@code user}.
     * @param user   The {@link User} to be written.
     * @throws IOException
     */
    private void writeUser(JsonWriter writer, User user) throws IOException {
        writer.beginObject();
        writer.name("Username").value(user.getUsername());
        writer.name("Password").value(user.getPassword());
        writer.name("SnakeSpeed").value(user.getSnakeSpeed());
        writer.endObject();
    }
}


