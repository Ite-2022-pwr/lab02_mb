package pl.pwr.ite.bedrylo.data;

import java.util.List;

public class AvailableStock {
    List<SkiGrouped> skis;
    
    public AvailableStock(List<SkiGrouped> skis) {
        this.skis = skis;
        this.skis.sort((s1, s2) -> s1.getSki().getType().compareTo(s2.getSki().getType()));
        
    }
    
    public List<SkiGrouped> getSkis() {
        return skis;
    }
    
    public void addSki(SkiGrouped ski) {
        skis.add(ski);
    }
    
    public Integer getSkisAmountByLength(Integer length) {
        for (SkiGrouped ski : skis) {
            if (ski.getSki().getLength().equals(length)) {
                return ski.getQuantity();
            }
        }
        return null;
    }
    
    public Integer getSkisAmountByType(SkiTypes type) {
        for (SkiGrouped ski : skis) {
            if (ski.getSki().getType().equals(type)) {
                return ski.getQuantity();
            }
        }
        return null;
    }
    
    public List<SkiGrouped> getSkisByType(SkiTypes type) {
        List<SkiGrouped> matchingSkis = null;
        for (SkiGrouped ski : skis) {
            if (ski.getSki().getType().equals(type)) {
                matchingSkis.add(ski);
            }
        }
        return matchingSkis;
    }
    
    public List<SkiGrouped> getSkisByLength(Integer length) {
        List<SkiGrouped> matchingSkis = null;
        for (SkiGrouped ski : skis) {
            if (ski.getSki().getLength().equals(length)) {
                matchingSkis.add(ski);
            }
        }
        return matchingSkis;
    }
}
