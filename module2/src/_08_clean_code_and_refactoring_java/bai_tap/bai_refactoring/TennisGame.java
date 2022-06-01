package _08_clean_code_and_refactoring_java.bai_tap.bai_refactoring;

public class TennisGame {
    public static String getScore(int player1Point, int player2Point) {
        String Score = "";

        if (player1Point == player2Point) {
            switch (player1Point) {
                case 0:
                    Score = "Love-All";
                    break;
                case 1:
                    Score = "Fifteen-All";
                    break;
                case 2:
                    Score = "Thirty-All";
                    break;
                case 3:
                    Score = "Forty-All";
                    break;
                default:
                    Score = "Deuce";
                    break;
            }
        } else if (player1Point >= 4 || player2Point >= 4) {
            Score = getMinusResult(player1Point, player2Point);
        } else {
            Score = getTempScore(player1Point, player2Point, Score);
        }
        return Score;
    }

    private static String getMinusResult(int player1Point, int player2Point) {
        String Score;
        int minusResult = player1Point - player2Point;
        if (minusResult == 1) {
            Score = "Advantage player1";
        } else if (minusResult == -1) {
            Score = "Advantage player2";
        } else if (minusResult >= 2) {
            Score = "Win for player1";
        } else {
            Score = "Win for player2";
        }
        return Score;
    }

    private static String getTempScore(int player1Point, int player2Point, String score) {
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = player1Point;
            } else {
                score += "-";
                tempScore = player2Point;
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }
}