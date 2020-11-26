
public class TennisGame2 implements TennisGame
{
    public int point_player_1 = 0;
    public int point_player_2 = 0;
    
    public String res_player_1 = "";
    public String res_player_2 = "";
    private String name_player_1;
    private String name_player_2;

    public TennisGame2(String name_player_1, String name_player_2) {
        this.name_player_1 = name_player_1;
        this.name_player_2 = name_player_2;
    }

    public String getScore(){
        String score = "";
        if (isEqualScore(point_player_1, point_player_2) && point_player_1 < 4)
        {
            score = getStringOfScore2(score, point_player_1, 0, "Love");
            score = getStringOfScore2(score, point_player_1, 1, "Fifteen");
            score = getStringOfScore2(score, point_player_1, 2, "Thirty");
            score += "-All";
        }
        if (isEqualScore(point_player_1, point_player_2) && point_player_1 >=3)
            score = "Deuce";

        score = getString_FirstPlayerVantageSecondToNull(score);

        if (point_player_2 > 0 && isEqualScore(point_player_1, 0))
        {
            res_player_2 = getStringOfScore2(res_player_2, point_player_2, 1, "Fifteen");
            res_player_2 = getStringOfScore2(res_player_2, point_player_2, 2, "Thirty");
            res_player_2 = getStringOfScore2(res_player_2, point_player_2, 3, "Forty");

            res_player_1 = "Love";
            score = res_player_1 + "-" + res_player_2;
        }
        
        if (point_player_1 > point_player_2 && point_player_1 < 4)
        {
            res_player_1 = getScoreString(res_player_1, point_player_1, 2, "Thirty");
            res_player_1 = getScoreString(res_player_1, point_player_1, 3, "Forty");
            res_player_2 = getScoreString(res_player_2, point_player_2, 1, "Fifteen");
            res_player_2 = getScoreString(res_player_2, point_player_2, 2, "Thirty");
            score = res_player_1 + "-" + res_player_2;
        }
        if (point_player_2 > point_player_1 && point_player_2 < 4)
        {
            res_player_2 = getScoreString(res_player_2, point_player_2, 2, "Thirty");
            res_player_2 = getScoreString(res_player_2, point_player_2, 3, "Forty");
            res_player_1 = getScoreString(res_player_1, point_player_1, 1, "Fifteen");
            res_player_1 = getScoreString(res_player_1, point_player_1, 2, "Thirty");
            score = res_player_1 + "-" + res_player_2;
        }

        score = getScoreStringFirstPlayerAdvantage(score, point_player_1, point_player_2, "Advantage player1");

        score = getScoreStringFirstPlayerAdvantage(score, point_player_2, point_player_1, "Advantage player2");

        score = getScoreFirstPlayerWin(score, point_player_1, point_player_2, "Win for player1");
        score = getScoreFirstPlayerWin(score, point_player_2, point_player_1, "Win for player2");

        return score;
    }

    private String getString_FirstPlayerVantageSecondToNull(String score) {
        if (point_player_1 > 0 && isEqualScore(point_player_2, 0))
        {
            res_player_1 = getStringOfScore2(res_player_1, point_player_1, 1, "Fifteen");
            res_player_1 = getStringOfScore2(res_player_1, point_player_1, 2, "Thirty");
            res_player_1 = getStringOfScore2(res_player_1, point_player_1, 3, "Forty");

            res_player_2 = "Love";
            score = res_player_1 + "-" + res_player_2;
        }
        return score;
    }

    private String getScoreFirstPlayerWin(String score, int point_player_1, int point_player_2, String s) {
        if (point_player_1 >= 4 && point_player_2 >= 0 && (point_player_1 - point_player_2) >= 2) {
            score = s;
        }
        return score;
    }

    private String getScoreStringFirstPlayerAdvantage(String score, int point_player_1, int point_player_2, String s) {
        if (point_player_1 > point_player_2 && point_player_2 >= 3) {
            score = s;
        }
        return score;
    }

    private String getStringOfScore2(String score, int point_player_1, int i, String love) {
        String score3 = score;
        score3 = getScoreString(score3, point_player_1, i, love);
        score = score3;
        return score;
    }

    private String getScoreString(String score3, int point_player_1, int i, String love) {
        if (isEqualScore(point_player_1, i))
            score3 = love;
        return score3;
    }

    private boolean isEqualScore(int point_player_1, int point_player_2) {
        return point_player_1 == point_player_2;
    }

    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        point_player_1++;
    }
    
    public void P2Score(){
        point_player_2++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}