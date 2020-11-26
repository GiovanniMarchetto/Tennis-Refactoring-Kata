
public class TennisGame1 implements TennisGame {
    
    private int score_player_1 = 0;
    private int score_player_2 = 0;
    private String name_player_1;
    private String name_player_2;

    public TennisGame1(String name_player_1, String name_player_2) {
        this.name_player_1 = name_player_1;
        this.name_player_2 = name_player_2;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            score_player_1 += 1;
        else
            score_player_2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (isScoreEqual(score_player_1, score_player_2))
        {
            switch (score_player_1)
            {
                case 0:
                        score = "Love-All";
                    break;
                case 1:
                        score = "Fifteen-All";
                    break;
                case 2:
                        score = "Thirty-All";
                    break;
                default:
                        score = "Deuce";
                    break;
                
            }
        }
        else if (isScoreMoreThanFour())
        {
            int minusResult = score_player_1 - score_player_2;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = score_player_1;
                else { score+="-"; tempScore = score_player_2;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }

    private boolean isScoreEqual(int score_player_1, int score_player_2) {
        return score_player_1 == score_player_2;
    }

    private boolean isScoreMoreThanFour() {
        return score_player_1 >= 4 || score_player_2 >= 4;
    }

}
