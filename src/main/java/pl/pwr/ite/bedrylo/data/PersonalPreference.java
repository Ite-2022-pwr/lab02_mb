package pl.pwr.ite.bedrylo.data;

import java.util.List;

public class PersonalPreference {
    private final Integer id;
    
    private final List<Ski> preferredSkis;
    
    private final Character ageGroup;
    
    private final Integer discount;
    
    public PersonalPreference(Integer id, List<Ski> preferredSkis, Character ageGroup) {
        this.id = id;
        this.preferredSkis = preferredSkis;
        this.ageGroup = ageGroup;
        this.discount = DiscountList.getDiscount(ageGroup);
    }
    
    public Integer getId() {
        return id;
    }
    
    public List<Ski> getPreferredSkis() {
        return preferredSkis;
    }
    
    public Character getAgeGroup() {
        return ageGroup;
    }
    
    public Integer getDiscount() {
        return discount;
    }
    
    @Override
    public String toString() {
        return "Preference{" +
                "id=" + id +
                ", preferredSkis=" + preferredSkis +
                ", ageGroup=" + ageGroup +
                ", discount=" + discount +
                '}';
    }
    
    
}
