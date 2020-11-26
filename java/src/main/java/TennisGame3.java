
public class TennisGame3 implements TennisGame {

    private int score_player_1;
    private int score_player_2;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        String s;
        if (score_player_1 < 4 && score_player_2 < 4 && !(score_player_1 + score_player_2 == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
            s = p[score_player_1];
            return (score_player_1 == score_player_2) ? s + "-All" : s + "-" + p[score_player_2];
        } else {
            if (score_player_1 == score_player_2)
                return "Deuce";
            s = score_player_1 > score_player_2 ? p1N : p2N;
            return ((score_player_1 - score_player_2)*(score_player_1 - score_player_2) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            this.score_player_1 += 1;
        else
            this.score_player_2 += 1;
        
    }

}
