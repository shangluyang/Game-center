package uoft.csc207.gameproject.user;

import java.util.HashMap;
import java.util.Map;

/**
 * the user status class, with current user info
 */
class UserStatusHandler {
	private Map<String, User> users;
	private User currentUser;

    /**
     * Initialize users' nap and current user
     */
    UserStatusHandler() {
        users = new HashMap<String, User>();
		currentUser = null;
	}

    /**
     * Get user info
     * @return user info
     */
    Map<String, User> getUsers() {
        return users;
    }

    /**
     * Set input to user
     * @param users input user
     */
    void setUsers(Map<String, User> users) {
        this.users = users;
    }

    /**
     * Return the current user of the application.
     *
     * @return The current user if the user is logged in, or null if not logged in.
     */
    User getCurrentUser() {
        return currentUser;
    }

    /**
     * Returns whether a user with the {@code username} is signed up before.
     *
     * @param username The input username
     * @return True if there is an existing user with the {@code username}, false otherwise.
     */
    private boolean isUserRegistered(String username) {
        return users.containsKey(username);
    }

    /**
     * Returns whether the login attempt is successful.
     *
     * @param username The input username
     * @param password The input password
     * @return True if the login attempt is successful, false otherwise.
     */
    boolean login(String username, String password) {
        if (isUserRegistered(username)) {
            for (Map.Entry<String, User> entry : users.entrySet()) {
                if (entry.getKey().equals(username) && entry.getValue().getPassword().equals(password)) {
                    currentUser = entry.getValue();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns whether the sign up attempt is successful.
     *
     * @param username The input username
     * @param password The input password
     * @return True if the sign up attempt is successful, false otherwise
     */
    boolean signUp(String username, String password) {
        if (isUserRegistered(username)) {
            return false;
        } else {
            users.put(username, new User(username, password));
            return true;
        }
    }

    /**
     * Set the current user to {@code null} when the user logout.
     */
    void logout() {
        currentUser = null;
    }
}
