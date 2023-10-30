package pl.pwr.ite.bedrylo.data;

import java.util.List;

public class AvailableStock {
    List<SkiGrouped> skis;
    
    public AvailableStock(List<SkiGrouped> skis) {
        this.skis = skis;
        
    }
    
    public List<SkiGrouped> getSkis() {
        return skis;
    }
    
    public void addSki(SkiGrouped ski) {
        skis.add(ski);
    }
    
    public void removeSki(SkiGrouped ski) {
        skis.get(skis.indexOf(ski)).setQuantity(skis.get(skis.indexOf(ski)).getQuantity() - 1);
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
    
    public Integer getTotalSkiAmount() {
        Integer total = 0;
        for (SkiGrouped ski : skis) {
            total += ski.getQuantity();
        }
        return total;
    }
}
