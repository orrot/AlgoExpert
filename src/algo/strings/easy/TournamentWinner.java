package algo.strings.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TournamentWinner {

    public static void main(String[] args) {
        // Returns the name of the champions winner
        // receive an array with the pairs with the teams of the match (competitions)
        // Receive an array with the results (1 the home team won, 0 the away team won)
        // each victory means 3 points for the winner

    }

    public static String getTournamentWinner(List<List<String>> competitions, List<Integer> results) {

        // Data validation will be here.

        Map<String, Integer> pointsByTeam = new HashMap<>();
        for (int i = 0; i < competitions.size(); i++) {
            List<String> matchTeams = competitions.get(i);
            Integer result = results.get(i);
            String winner = result == 1 ? matchTeams.get(0) : matchTeams.get(1);
            pointsByTeam.compute(winner, (team, currentPoints) -> currentPoints == null ? 3 : currentPoints + 3);
        }

        return pointsByTeam.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
