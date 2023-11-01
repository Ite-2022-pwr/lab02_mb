package pl.pwr.ite.bedrylo.data;

import java.util.ArrayList;
import java.util.Arrays;

public class MatchList {
    private ArrayList<Match> matches = new ArrayList<>();
    
    private Float points = 0f;
    
    private Integer nonNullMatches = 0;
    
    public MatchList() {}
    
    public ArrayList<Match> getMatches() {
        return matches;
    }
    
    public Float getPoints() {
        return points;
    }
    
    public void addMatch(Match match) {
        matches.add(match);
        if (match.getSki() != null) {
            nonNullMatches++;
        }
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
    
    public Integer getNonNullMatches() {
        return nonNullMatches;
    }
    
    public ArrayList<Match> getTopNMatches(Integer n) {
        this.sortDescendingPoints();
        ArrayList<Match> topNMatches = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            topNMatches.add(matches.get(i));
        }
        return topNMatches;
    }
    
    @Override
    public String toString() {
        return "MatchList{" +
                "matches=" + matches.size() +
                ", points=" + points +
                ", nonNullMatches=" + nonNullMatches +
                '}';
    }
    
    public String toFileString() {
        StringBuilder line = new StringBuilder();
        line.append("matches:").append(matches.size()).append(",points:").append(points).append(",nonNullMatches:").append(nonNullMatches).append("\n");
        line.append("preferenceId,ageGroup,prefferedSkis->matchedSki,points\n");
        for (var match : matches) {
            line.append(match.getPreferenceId()).append(",").append(PreferenceList.getPreferenceById(match.getPreferenceId()).getAgeGroup()).append(",");
            for (var ski : PreferenceList.getPreferenceById(match.getPreferenceId()).getPrefferedSkis()) {
                line.append(ski.getType()).append(":").append(ski.getLength()).append(";");
            }
            line.append("->");
            if (match.getSki() == null){
                line.append("null");
            } else {
                line.append(match.getSki().getType()).append(":").append(match.getSki().getLength());
            }
            line.append(",").append(match.getPoints()).append("\n");
        }
        return line.toString();
    }
    
}
