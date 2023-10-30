package pl.pwr.ite.bedrylo.data;

import pl.pwr.ite.bedrylo.logic.PairPointsCalculator;

import java.util.HashMap;

public class SkiPreferencePair {
    private Ski ski;
    private PersonalPreference preference;

    public SkiPreferencePair(Ski ski, PersonalPreference preference) {
        this.ski = ski;
        this.preference = preference;
    }

    public Ski getSki() {
        return ski;
    }

    public PersonalPreference getPreference() {
        return preference;
    }
    
    public HashMap<Ski, Float> pairPoints() {
        return PairPointsCalculator.calculatePairPoints(preference, ski);
    }

    @Override
    public String toString() {
        return ski.toString() + " " + preference.toString();
    }
}
