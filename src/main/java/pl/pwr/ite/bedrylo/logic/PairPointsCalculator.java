package pl.pwr.ite.bedrylo.logic;

import org.jetbrains.annotations.NotNull;
import pl.pwr.ite.bedrylo.data.PersonalPreference;
import pl.pwr.ite.bedrylo.data.Ski;

import java.util.HashMap;

public abstract class PairPointsCalculator {
    public static @NotNull HashMap<Ski, Float> calculatePairPoints(PersonalPreference preference, Ski ski){
        Float points = null;
        Ski bestSki = null;
        for (Ski PreferenceSki : preference.getPrefferedSkis()) {
            Float tempPoints = 0f;
            if (ski.getType().equals(PreferenceSki.getType())) {
                tempPoints += 100f;
            } else {
                tempPoints -= 100f;
            }
            if (ski.getLength().equals(PreferenceSki.getLength())) {
                tempPoints += 100f;
            } else {
                tempPoints -= 3f*(Math.abs(ski.getLength() - PreferenceSki.getLength()));
            }
            tempPoints *= (((100 - preference.getDiscount()))/100f);
            if (points == null) {
                points = tempPoints;
                bestSki = PreferenceSki;
            } else if (tempPoints >= points) {
                points = tempPoints;
                bestSki = PreferenceSki;
            }
        }
        HashMap<Ski, Float> pointsMap = new HashMap<>();
        pointsMap.put(bestSki, points);
        return pointsMap;
    }
}
