package uoft.csc207.gameproject;

import android.app.Application;

import uoft.csc207.gameproject.scoreboard.ScoreboardManager;
import uoft.csc207.gameproject.user.UserManager;

/**
 * GameApplication is a child class of Application. As a child class of Application which is
 * registered in the AndroidManifest.xml file, it is instantiated as the application being
 * started. It provides to the instance through the static method getInstance().
 * GameApplication provides access to methods in Application for classes which do not have the
 * getApplication() method, for example, custom file handlers which use getExternalFilesDir() method.
 * GameApplication has a UserManager and ScoreboardManager as instance variables to manage all the
 * users of the application and the scoreboards of the games.
 */
public class GameApplication extends Application {
	private static GameApplication instance;
	private UserManager userManager;
	private ScoreboardManager scoreboardManager;

	/**
	 * The method is called as the android application is being started. It initializes the static
	 * variables and instance variables to provide access to such variables later on.
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		userManager = new UserManager();
		scoreboardManager = new ScoreboardManager();
	}

	/**
	 * Return the UserManager variable, which interacts with the users of the application.
	 */
	public UserManager getUserManager() {
		return userManager;
	}

	/**
	 * Return the ScoreboardManager variable, which interacts with the scoreboards of the games.
	 */
	public ScoreboardManager getScoreboardManager() {
		return scoreboardManager;
	}

	/**
	 * Return the static instance of GameApplication.
	 */
	public static GameApplication getInstance() {
		return instance;
	}
}
