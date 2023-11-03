package pl.pwr.ite.bedrylo.data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class PreferenceList {
    private static final ArrayList<PersonalPreference> preferences = new ArrayList<>();

    public static List<PersonalPreference> getPreferences() {
        return preferences;
    }
    
    public static void addPreference(PersonalPreference preference) {
        preferences.add(preference);
    }
    
    public static PersonalPreference getPreferenceById(Integer id) {
        return preferences.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public static Integer getPreferenceAmount() {
        return preferences.size();
    }
    
    public static void sortByDiscountAscending() {
        preferences.sort(Comparator.comparing(PersonalPreference::getDiscount));
    }
}
