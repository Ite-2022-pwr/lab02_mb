package pl.pwr.ite.bedrylo.data;

import java.util.ArrayList;

public class MatchList {
    private ArrayList<Match> matches = new ArrayList<>();
    
    private Float points = 0f;
    
    public MatchList() {}
    
    public ArrayList<Match> getMatches() {
        return matches;
    }
    
    public Float getPoints() {
        return points;
    }
    
    public void addMatch(Match match) {
        matches.add(match);
        points += match.getPoints();
    }
    
    public void sortDescendingPoints() {
        matches.sort((o1, o2) -> {
            if (o1.getPoints() > o2.getPoints()) {
                return -1;
            } else if (o1.getPoints().equals(o2.getPoints())) {
                return 0;
            } else {
                return 1;
            }
        });
    }
    
    public ArrayList<Match> getTopNMatches(Integer n) {
        ArrayList<Match> topNMatches = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            topNMatches.add(matches.get(i));
        }
        return topNMatches;
    }
    
}
