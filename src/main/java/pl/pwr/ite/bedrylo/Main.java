package pl.pwr.ite.bedrylo;

import pl.pwr.ite.bedrylo.data.AvailableStock;
import pl.pwr.ite.bedrylo.data.PersonalPreference;
import pl.pwr.ite.bedrylo.data.PreferenceList;
import pl.pwr.ite.bedrylo.data.SkiGrouped;
import pl.pwr.ite.bedrylo.logic.PairPointsCalculator;
import pl.pwr.ite.bedrylo.misc.ConfigClass;
import pl.pwr.ite.bedrylo.misc.FileHandler;

public class Main {
    public static void main(String[] args) {
        FileHandler.readDiscountList(ConfigClass.getDiscountsListPath());
        AvailableStock availableStock = new AvailableStock(FileHandler.readSkiList(ConfigClass.getSkiListPath()));
        PreferenceList preferenceList = new PreferenceList(FileHandler.readPreferenceList(ConfigClass.getPreferencesListPath()));
        for (SkiGrouped skiGrouped : availableStock.getSkis()) {
            System.out.println(skiGrouped);
        }
        for(PersonalPreference personalPreference : preferenceList.getPreferences()) {
            System.out.println(personalPreference);
        }
        System.out.println(availableStock.getTotalSkiAmount());
        System.out.println(preferenceList.getPreferenceAmount());
        System.out.println(availableStock.getSkis().get(0).getSki());
        System.out.println(preferenceList.getPreferences().get(0));
        System.out.println(PairPointsCalculator.calculatePairPoints(preferenceList.getPreferences().get(0),availableStock.getSkis().get(0).getSki()));
    }
}