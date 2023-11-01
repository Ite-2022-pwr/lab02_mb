package pl.pwr.ite.bedrylo;

import pl.pwr.ite.bedrylo.data.*;
import pl.pwr.ite.bedrylo.logic.Evolution;
import pl.pwr.ite.bedrylo.misc.ConfigClass;
import pl.pwr.ite.bedrylo.misc.FileHandler;


public class TestMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        ConfigClass.setSkiListPath("src/main/java/pl/pwr/ite/bedrylo/resources/wykaz.txt");
        ConfigClass.setPreferencesListPath("src/main/java/pl/pwr/ite/bedrylo/resources/preferences.txt");
        ConfigClass.setDiscountsListPath("src/main/java/pl/pwr/ite/bedrylo/resources/znizki.txt");
        ConfigClass.setGenerationMaxNumber(1000);
        ConfigClass.setMatchListCount(30);
        ConfigClass.setComparisonAmount(4);
        AvailableStock availableStock = new AvailableStock(FileHandler.readSkiList(ConfigClass.getSkiListPath()));
        FileHandler.readDiscountList(ConfigClass.getDiscountsListPath());
        FileHandler.readPreferenceList(ConfigClass.getPreferencesListPath());
        PreferenceList.sortByDiscountAscending();
        MatchList matchList = Evolution.evolve(availableStock, ConfigClass.getGenerationMaxNumber(), ConfigClass.getMatchListCount(), ConfigClass.getComparisonAmount());
        System.out.println(matchList);
        
    }
}