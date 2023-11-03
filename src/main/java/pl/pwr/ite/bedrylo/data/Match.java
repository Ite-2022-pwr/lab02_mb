package pl.pwr.ite.bedrylo.data;

import pl.pwr.ite.bedrylo.logic.PairPointsCalculator;

public class Match {
    private final Integer preferenceId;
    
    private final Ski ski;
    
    private final Float points;
    
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
                ", preferred skis=" + PreferenceList.getPreferenceById(preferenceId).getPreferredSkis() +
                ", discount type=" + PreferenceList.getPreferenceById(preferenceId).getAgeGroup() +
                ", ski=" + ski +
                ", points=" + points +
                '}';
    }
}
