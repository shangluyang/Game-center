README

Welcome to our CSC207 game project - Three Deadly Sins! In this project, we implemented an app that contains three games, 
each with two to three levels: a puzzle-solving game named Sin of Sloth, a turn-based RPG game Sin of Gluttony and an exciting 
challenge called Sin of Greed that tests both your luck and courage. We sincerely hope that you enjoy experimenting with the 
three "Sins" while learning lessons from them. The games were implemented using a Model-View-Presenter design that closely 
follows the guidelines of SOLID principles. 

Installation Instructions:
1. To run the app, you will need to install Android Studio on your machine. 
2. Once Android Studio is installed, run it. You need to create a virtual device.
	- Select Tools->AVD Manager
	- Click the "+ Create Virtual Device" button at the bottom of the window
	- Choose Pixel 3 and click Next
	- Choose Pie and click Next
	- Click Finish
2. In Android Studio, click "Check out from version control"
3. Copy and paste this URL and click Clone: https://markus.teach.cs.toronto.edu/git/csc207-2019-09/group_0639
4. The application should be ready to run.

Playing the Games:
Each registered user will have access to a home page, on which they will be able to reset their password, check the scoreboard as 
well as to choose one of our three games. When the app is run with emulator, you will be taken to an interface where a login 
window is displayed. If this is your first time playing, please click on the "Sign up" icon that will send you to the sign-up page to 
get an account. You will then be taken to an interface where a login prompt is displayed when the app is running with an emulator.
Please only use a permutation of letters and numbers for your username and password. 

Game 1: Sin of Sloth
Our main character of the game is represented by the yellow cat icon, and the goal of the game is to surround the weights around the cat
so that the cat is trapped by the weights. The second level of the game has two cats that needs to lift some weights, while the third level
of the game has a "food" feature. The weights around the food will be destroyed once a cat eats the food. Score of this game is calculated
by subtracting steps from 100. In other words, the fewer steps you take to trap the cat, the higher marks you get for the game.

Game 2: Sin of Gluttony
Sin of Gluttony is similar to the classic game: Snake, in which you control a snake and it can eat the orange dot with the front of its body
which extends the body by one segment. In the second level of Snake, there are barriers that blocks the snake's movement while in the 
third level of the game, once the snake touches the moving red dots with any body parts, it will die. Score of this game is calculated based 
on the number of dots you have eaten in the game.

Game 3: Sin of Greed
The goal of this game is to win as many points as possible without reaching zero points. In the first level, enter the number of points that 
you wish to bet and click "gamble".  The second level of the game is to first enter the amount of points you wish to bet on, then enter the 
number of points you wish to earn. Click "analyze" to show the odds of this gamble. Then, click gamble to start the game. Score of this 
game will be counted based on the highest score that you have achieved before reaching zero points.

Have fun playing the games!

Built With:
Android Studio
Git

