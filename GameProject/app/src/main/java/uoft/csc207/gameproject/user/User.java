package uoft.csc207.gameproject.user;

/**
 * The user class, with user information
 */
public class User {
	private String username;
	private String password;
	private long snakeSpeed;

	/**
	 * Initialize user info
	 * @param username username input
	 * @param password password input
	 */
	User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * Get username of this user
	 * @return username of this user
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Get password of this user
	 * @return password of this user
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password of the user to the new password.
	 *
	 * @param password The new password of the user.
	 */
	public void resetPassword(String password) {
		this.password = password;
	}

	/**
	 * Get snake speed of this user's customization
	 * @return snake speed
	 */
	long getSnakeSpeed() {
		return snakeSpeed;
	}

	/**
	 * Set snake speed of this user's customization
	 * @param snakeSpeed input of user
	 */
	void setSnakeSpeed(long snakeSpeed) {
		this.snakeSpeed = snakeSpeed;
	}
}
