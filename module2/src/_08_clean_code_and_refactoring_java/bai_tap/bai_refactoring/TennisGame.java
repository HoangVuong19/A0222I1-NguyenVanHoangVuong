package _08_clean_code_and_refactoring_java.bai_tap.bai_refactoring;

public class TennisGame {

    //region constant
    private static final String ZERO_SCORE = "Love";
    private static final String ONE_SCORE = "Fifteen";
    private static final String TWO_SCORE = "Thirty";
    private static final String THREE_SCORE = "Forty";
    private static final String ALL = "All";
    private static final String WIN = "Win";
    private static final String DEUCE = "Deuce";
    private static final String ADVANTAGE = "Advantage";


    public static String getScore(int playerOneScore, int playerTwoScore) {

        if (playerOneScore == playerTwoScore) {
            return displayDeuce(playerOneScore) + "-" + ALL;
        }
        if (playerOneScore >= 4 || playerTwoScore >= 4) {
            return displayAdvantageOrWin(playerOneScore, playerTwoScore);
        }
        return displayScore(playerOneScore, playerTwoScore);
    }

    private static String displayDeuce(int score) {
        switch (score) {
            case 0:
                return ZERO_SCORE;
            case 1:
                return ONE_SCORE;
            case 2:
                return TWO_SCORE;
            case 3:
                return THREE_SCORE;
            default:
                return DEUCE;
        }
    }

    private static String displayAdvantageOrWin(int playerOneScore, int playerTwoScore) {
        int minusResult = playerOneScore - playerTwoScore;
        if (minusResult == 1) {
            return ADVANTAGE + " playerOne";
        } else if (minusResult == -1) {
            return ADVANTAGE + " playerTwo";
        } else if (minusResult >= 2) {
            return WIN + " playerOne";
        } else {
            return WIN + " playerTwo";
        }
    }

    private static String displayScore(int playerOneScore, int playerTwoScore) {
        return displayDeuce(playerOneScore) + "-" + displayDeuce(playerTwoScore);
    }
}