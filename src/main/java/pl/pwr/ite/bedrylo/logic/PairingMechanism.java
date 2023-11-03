package pl.pwr.ite.bedrylo.logic;

import pl.pwr.ite.bedrylo.data.*;

public abstract class PairingMechanism {
    
    public static Match pair(PersonalPreference preference, AvailableStock availableStock, Integer amount) {
        Float points = null;
        Ski bestSki = null;
        if (availableStock.getSkis() == null || availableStock.getSkis().isEmpty()) {
            return new Match(preference.getId(), null);
        } else if (availableStock.getTotalSkiAmount() < amount) {
            amount = availableStock.getTotalSkiAmount();
        }
        for (int i = 0; i < amount; i++) {
            Ski randomSki = availableStock.getRandomSki();
            Float tempPoints = PairPointsCalculator.calculatePairPoints(preference, randomSki);
            if (points == null) {
                points = tempPoints;
                bestSki = randomSki;
            } else if (tempPoints >= points) {
                points = tempPoints;
                bestSki = randomSki;
            }
        }
        if (PairPointsCalculator.calculatePairPoints(preference, null) > points) {
            return new Match(preference.getId(), null);
        } else {
            availableStock.removeSki(bestSki);
            return new Match(preference.getId(), bestSki);
        }
    }
}
