package pl.pwr.ite.bedrylo;

import pl.pwr.ite.bedrylo.data.AvailableStock;
import pl.pwr.ite.bedrylo.data.PersonalPreference;
import pl.pwr.ite.bedrylo.data.PreferenceList;
import pl.pwr.ite.bedrylo.data.SkiGrouped;
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
        
    }
}