package pl.pwr.ite.bedrylo.logic;

import org.jetbrains.annotations.NotNull;
import pl.pwr.ite.bedrylo.data.*;

import java.util.List;
import java.util.Random;

public abstract class PairingMechanism {
    
    public static Match pair(PersonalPreference preference, AvailableStock availableStock, Integer amount) {
        Float points = null;
        Ski bestSki = null;
        List<SkiGrouped> test = availableStock.getSkis();
        if (availableStock.getSkis().isEmpty() || availableStock.getSkis() == null) {
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
