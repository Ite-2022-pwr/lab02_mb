package pl.pwr.ite.bedrylo.data;

import java.util.List;

public class PersonalPreference {
    private Integer id;
    
    private List<Ski> prefferedSkis;
    
    private Character ageGroup;
    
    private Integer discount;
    
    public PersonalPreference(Integer id, List<Ski> prefferedSkis, Character ageGroup) {
        this.id = id;
        this.prefferedSkis = prefferedSkis;
        this.ageGroup = ageGroup;
        this.discount = DiscountList.getDiscount(ageGroup);
    }
    
    public Integer getId() {
        return id;
    }
    
    public List<Ski> getPrefferedSkis() {
        return prefferedSkis;
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
                ", prefferedSkis=" + prefferedSkis +
                ", ageGroup=" + ageGroup +
                ", discount=" + discount +
                '}';
    }
    
    
}
