package uoft.csc207.gameproject.game.gamble;


/**
 * a class for gambler
 */
class Gambler {

  private Integer points = 50;
  private Integer highscore = 0;
  private String title = "Good Luck!";

  /**
   * the initializer for gambler
   */
  Gambler() {
  }

  /**
   * calculate the result of gamble
   * @param input  the points you want to spend
   * @param output the points you want to gain
   */
  public void gamble(Integer input, Integer output) {
    double Odd = get_Odd(input, output) / 100;
    double rand = Math.random();
    if (input > points) {
      title = "Insufficient";
    } else if (rand < Odd) {
      points += input;
      title = "You Won :)";
    } else {
      points -= input;
      title = "You Lost :(";
    }
    if (points > highscore) {
      highscore = points;
    }
  }

  /**
   * calculate the odd with given input and output
   * @param input points gambler want to spend
   * @param output points gambler want to use
   * @return the odd
   */
  private double get_Odd(Integer input, Integer output) {
    double d_input = (double) input;
    double d_output = (double) output;
    double mul = d_output / d_input;
    if (mul >= 1) {
      return 50 / mul;
    } else {
      return 100 - (50 * mul);
    }
  }

  /**
   * return the string after calculating odd
   *
   * @param input  the points gambler wish to spend
   * @param output the points gambler wish to earn
   * @return the String display of screen for oddLine
   */
  String get_OddLine(Integer input, Integer output){
    return "Odd: " + get_Odd(input,output) + "% to win";
  }

  /**
   * return points
   * @return the points
   */
  Integer getPoints() {
    return points;
  }

  /**
   * return Highscore
   * @return Highscore
   */
  Integer getHighscore() {
    return highscore;
  }

  /**
   * return Highscore
   * @return Highscore
   */
  String getTitle() {
    return title;
  }
    }


