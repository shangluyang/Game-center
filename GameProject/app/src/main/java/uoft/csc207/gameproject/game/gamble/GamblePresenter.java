package uoft.csc207.gameproject.game.gamble;

/**
 * The presenter class works as a middle man between GambleActivity/gamble2Activity and Gambler
 */
class GamblePresenter {
    private GambleView view;
    private Gambler gambler;

    /**
     * initializer for GamblePresenter.
     */
    GamblePresenter(GambleView view) {
        this.view = view;
        this.gambler = new Gambler();
    }

    /**
     * calculate the gamble result in Gambler and update the result in Activity
     *
     * @param input  the points you wish to spend
     * @param output the points you wish the gain
     */
    void startGamble(Integer input, Integer output){
        gambler.gamble(input, output);
        if (gambler.getPoints() <= 0){
            view.lose();
        } else {
            view.updatePoints(gambler.getPoints());
            view.updateHighscore(gambler.getHighscore());
            view.updateTitle(gambler.getTitle());
        }
    }

    /**
     * calculate the analyze result in Gambler and update the result in Activity
     *
     * @param input  the points you wish to spend
     * @param output the points you wish the gain
     */
    void startAnalyze(Integer input, Integer output){
        view.updateOdd(gambler.get_OddLine(input, output));

    }

}
