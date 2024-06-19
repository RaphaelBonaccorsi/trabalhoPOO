import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserAuthentication {
    private Map<String, String> users;
    private static final String USER_FILE = "user.txt";

    public UserAuthentication() {
        users = new HashMap<>();
        loadUsersFromFile();
    }

    public boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public void addUser(String username, String password) {
        users.put(username, password);
        saveUsersToFile();
    }

    private void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    users.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading users from file: " + e.getMessage());
        }
    }

    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE))) {
            for (Map.Entry<String, String> entry : users.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving users to file: " + e.getMessage());
        }
    }
}
