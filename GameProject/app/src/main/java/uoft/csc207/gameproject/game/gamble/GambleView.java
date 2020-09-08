package uoft.csc207.gameproject.game.gamble;

/**
 * an view interface for gamble
 */
interface GambleView {

    void updatePoints(Integer points);

    void updateHighscore(Integer highscore);

    void updateTitle(String Title);

    void updateOdd(String oddLine);

    void lose();
}
