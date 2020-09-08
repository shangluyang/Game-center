package uoft.csc207.gameproject.user;

/**
 * Manages all the information of the users of the application.
 */
public class UserManager {
    private static final String FILE_NAME = "Users.json";
    private UserStatusHandler statusHandler;
    private UserFileHandler fileHandler;

    /**
     * Initialize UserStatusHandler and UserFileHandler
     */
    public UserManager() {
        fileHandler = new UserFileHandler();
        statusHandler = new UserStatusHandler();
        loadFromFile();
    }

    /**
     * Return the current user of the application.
     *
     * @return The current user if the user is logged in, or null if not logged in.
     */
    public User getCurrentUser() {
        return statusHandler.getCurrentUser();
    }

    /**
     * Returns whether the login attempt is successful.
     *
     * @param username The input username
     * @param password The input password
     * @return True if the login attempt is successful, false otherwise.
     */
    public boolean login(String username, String password) {
        return statusHandler.login(username, password);
    }

    /**
     * Returns whether the sign up attempt is successful.
     *
     * @param username The input username
     * @param password The input password
     * @return True if the sign up attempt is successful, false otherwise
     */
    public boolean signUp(String username, String password) {
        return statusHandler.signUp(username, password);
    }

    /**
     * Set the current user to {@code null} when the user logout.
     */
    public void logout() {
        statusHandler.logout();
    }

    /**
     * Loads the user information to memory.
     */
    private void loadFromFile() {
        fileHandler.loadFromFile();
        statusHandler.setUsers(fileHandler.getUsers());
    }

    /**
     * Saves the user information to file.
     */
    public void saveToFile() {
        fileHandler.setUsers(statusHandler.getUsers());
        fileHandler.saveToFile();
    }
}

