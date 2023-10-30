package pl.pwr.ite.bedrylo.data;

import org.jetbrains.annotations.NotNull;
import pl.pwr.ite.bedrylo.logic.PairPointsCalculator;

import java.util.List;
import java.util.Random;

public class AvailableStock implements Cloneable{
    
    public static final Random random = new Random();
    static List<SkiGrouped> skis;
    
    public AvailableStock(List<SkiGrouped> skis) {
        this.skis = skis;
    }
    
    public AvailableStock(@NotNull AvailableStock availableStock) {
        //TODO przerób na array list może podziałą
        for (SkiGrouped skiGrouped : availableStock.getSkis()) {
            this.skis.add(new SkiGrouped(skiGrouped.getSki(), skiGrouped.getQuantity()));            
        }
    }
    
    public List<SkiGrouped> getSkis() {
        return skis;
    }
    
    public void addSki(SkiGrouped ski) {
        skis.add(ski);
    }
    
    public static void removeSki(Ski ski) {
        for (SkiGrouped skiGrouped : skis) {
            if (skiGrouped.getSki().equals(ski)) {
                skiGrouped.setQuantity(skiGrouped.getQuantity() - 1);
                if (skiGrouped.getQuantity() == 0) {
                    skis.remove(skiGrouped);
                }
                return;
            }
        }
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
    
    public SkiGrouped getExactSki(Ski ski) {
        for (SkiGrouped skiGrouped : skis) {
            if (skiGrouped.getSki().equals(ski)) {
                return skiGrouped;
            }
        }
        return null;
    }
    
    public Integer getExactSkiAmount(Ski ski) {
        for (SkiGrouped skiGrouped : skis) {
            if (skiGrouped.getSki().equals(ski)) {
                return skiGrouped.getQuantity();
            }
        }
        return null;
    }
    
    public Ski getRandomSki() {
        return skis.get(random.nextInt(skis.size())).getSki();
    }
}
