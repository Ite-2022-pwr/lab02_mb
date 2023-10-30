package pl.pwr.ite.bedrylo.data;

import java.util.List;

public class PreferenceList {
    private List<PersonalPreference> preferences;
    
    public PreferenceList(List<PersonalPreference> preferences) {
        this.preferences = preferences;
    }
    
    public List<PersonalPreference> getPreferences() {
        return preferences;
    }
    
    public List<PersonalPreference> getPreferencesByAgeGroup(Character ageGroup) {
        return preferences.stream()
                .filter(p -> p.getAgeGroup().equals(ageGroup))
                .toList();
    }
    
    public List<PersonalPreference> getPreferencesBySkiType(SkiTypes skiType) {
        return preferences.stream()
                .filter(p -> p.getPrefferedSkis().stream().anyMatch(s -> s.getType().equals(skiType)))
                .toList();
    }
    
    public List<PersonalPreference> getPreferencesBySkiLength(Integer skiLength) {
        return preferences.stream()
                .filter(p -> p.getPrefferedSkis().stream().anyMatch(s -> s.getLength().equals(skiLength)))
                .toList();
    }
}
