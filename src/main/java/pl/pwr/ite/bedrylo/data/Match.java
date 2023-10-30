package pl.pwr.ite.bedrylo.data;

import pl.pwr.ite.bedrylo.logic.PairPointsCalculator;

public class Match {
    private Integer preferenceId;
    
    private Ski ski;
    
    private Float points;
    
    public Match(Integer preferenceId, Ski ski) {
        this.preferenceId = preferenceId;
        this.ski = ski;
        this.points = PairPointsCalculator.calculatePairPoints(PreferenceList.getPreferenceById(preferenceId), ski);
    }
    
    public Integer getPreferenceId() {
        return preferenceId;
    }
    
    public Ski getSki() {
        return ski;
    }
    
    public Float getPoints() {
        return points;
    }
    
    @Override
    public String toString() {
        return "Match{" +
                "preferenceId=" + preferenceId +
                ", ski=" + ski +
                ", points=" + points +
                '}';
    }
}
