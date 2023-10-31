package pl.pwr.ite.bedrylo.data;

import java.util.*;
import java.util.stream.Collectors;

public class AvailableStock implements Cloneable{
    
    public static final Random random = new Random();
    private ArrayList<SkiGrouped> skis;
    
    public AvailableStock(ArrayList<SkiGrouped> skis) {
        this.skis = skis;
    }
    
    public AvailableStock() {
        skis = new ArrayList<>();
    }
    
//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        AvailableStock clone = null;
//        try {
//            clone = (AvailableStock) super.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        skis = new ArrayList<>(skis);
//        Collections.copy(skis, AvailableStock.getSkis());
//        return clone;
//    }
    
    public AvailableStock(AvailableStock availableStock){
        this.skis = new ArrayList<SkiGrouped>();
        for (SkiGrouped skiGrouped : availableStock.getSkis()) {
            this.skis.add(new SkiGrouped(skiGrouped.getSki(), skiGrouped.getQuantity()));
        }
    }
    
    public ArrayList<SkiGrouped> getSkis() {
        return this.skis;
    }
    
    public void addSki(SkiGrouped ski) {
        skis.add(ski);
    }
    
    public void removeSki(Ski ski) {
        for (SkiGrouped skiGrouped : this.skis) {
            if (skiGrouped.getSki().equals(ski)) {
                skiGrouped.setQuantity(skiGrouped.getQuantity() - 1);
                if (skiGrouped.getQuantity() == 0) {
                    this.skis.remove(skiGrouped);
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
    
    public void setSkis(ArrayList<SkiGrouped> skis) {
        Collections.copy(this.skis, skis);
    }
    
    public Ski getRandomSki() {
        return skis.get(random.nextInt(skis.size())).getSki();
    }
}
