package pl.pwr.ite.bedrylo;

import pl.pwr.ite.bedrylo.data.*;
import pl.pwr.ite.bedrylo.logic.PairPointsCalculator;
import pl.pwr.ite.bedrylo.misc.ConfigClass;
import pl.pwr.ite.bedrylo.misc.FileHandler;

public class TestMain {
    public static void main(String[] args) {
        FileHandler.readDiscountList(ConfigClass.getDiscountsListPath());
        FileHandler.readPreferenceList(ConfigClass.getPreferencesListPath());
        AvailableStock availableStock = new AvailableStock(FileHandler.readSkiList(ConfigClass.getSkiListPath()));
        for (SkiGrouped skiGrouped : availableStock.getSkis()) {
            System.out.println(skiGrouped);
        }
        for(PersonalPreference personalPreference : PreferenceList.getPreferences()) {
            System.out.println(personalPreference);
        }
        System.out.println(availableStock.getTotalSkiAmount());
        System.out.println(PreferenceList.getPreferenceAmount());
        System.out.println(availableStock.getSkis().get(0).getSki());
        System.out.println(PreferenceList.getPreferences().get(0));
        System.out.println(PairPointsCalculator.calculatePairPoints(PreferenceList.getPreferences().get(0),availableStock.getSkis().get(0).getSki()));
        System.out.println(PairPointsCalculator.calculatePairPoints(PreferenceList.getPreferences().get(0),null));
        Match match = new Match(PreferenceList.getPreferences().get(0).getId(),null);
        System.out.println(match);
    }
}