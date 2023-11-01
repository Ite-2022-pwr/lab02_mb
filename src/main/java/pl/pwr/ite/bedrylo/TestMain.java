package pl.pwr.ite.bedrylo;

import pl.pwr.ite.bedrylo.data.*;
import pl.pwr.ite.bedrylo.logic.*;
import pl.pwr.ite.bedrylo.misc.ConfigClass;
import pl.pwr.ite.bedrylo.misc.FileHandler;

public class TestMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        FileHandler.readDiscountList(ConfigClass.getDiscountsListPath());
        FileHandler.readPreferenceList(ConfigClass.getPreferencesListPath());
        AvailableStock availableStock = new AvailableStock(FileHandler.readSkiList(ConfigClass.getSkiListPath()));
//        for (SkiGrouped skiGrouped : availableStock.getSkis()) {
//            System.out.println(skiGrouped);
//        }
//        for(PersonalPreference personalPreference : PreferenceList.getPreferences()) {
//            System.out.println(personalPreference);
//        }
        PreferenceList.sortByDiscountAscending();
//        for(PersonalPreference personalPreference : PreferenceList.getPreferences()) {
//            System.out.println(personalPreference);
//        }
//        System.out.println(availableStock.getTotalSkiAmount());
//        System.out.println(PreferenceList.getPreferenceAmount());
//        System.out.println(availableStock.getSkis().get(0).getSki());
//        System.out.println(PreferenceList.getPreferences().get(0));
//        System.out.println(PairPointsCalculator.calculatePairPoints(PreferenceList.getPreferences().get(0),availableStock.getSkis().get(0).getSki()));
//        System.out.println(PairPointsCalculator.calculatePairPoints(PreferenceList.getPreferences().get(0),null));
//        Match match = new Match(PreferenceList.getPreferences().get(0).getId(),null);
//        System.out.println(match);
//        System.out.println(availableStock.getRandomSki());
//        System.out.println(PairingMechanism.pair(PreferenceList.getPreferences().get(0),availableStock,10));

//        MatchList testowa = MatchListGenerator.generateMatchList(availableStock, null,10);
//        for (Match match : testowa.getMatches()) {
//            System.out.println(match);
//        }
//        System.out.println(testowa);
//        System.out.println(testowa.getTopNMatches(10));
        
//        
        MatchList bestMatchList = Evolution.evolve(availableStock, 1000, 30, 4);
        System.out.println(bestMatchList);
        for (Match match : bestMatchList.getMatches()) {
            System.out.println(match);
        }
    }
}