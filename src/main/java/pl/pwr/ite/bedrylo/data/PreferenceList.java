package pl.pwr.ite.bedrylo.data;

import java.util.ArrayList;
import java.util.List;

public abstract class PreferenceList {
    private static ArrayList<PersonalPreference> preferences = new ArrayList<>();

    public static List<PersonalPreference> getPreferences() {
        return preferences;
    }
    
    public static Void addPreference(PersonalPreference preference) {
        preferences.add(preference);
        return null;
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
    
    public static Void sortByDiscountAscending() {
        preferences.sort((p1, p2) -> p1.getDiscount().compareTo(p2.getDiscount()));
        return null;
    }
}
