package pl.pwr.ite.bedrylo.data;

import java.util.*;

public class AvailableStock{
    
    public static final Random random = new Random();
    private final ArrayList<SkiGrouped> skis;
    
    public AvailableStock(ArrayList<SkiGrouped> skis) {
        this.skis = skis;
    }
    
    public AvailableStock(AvailableStock availableStock){
        this.skis = new ArrayList<>();
        for (SkiGrouped skiGrouped : availableStock.getSkis()) {
            this.skis.add(new SkiGrouped(skiGrouped.getSki(), skiGrouped.getQuantity()));
        }
    }
    
    public ArrayList<SkiGrouped> getSkis() {
        return this.skis;
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

    public Integer getTotalSkiAmount() {
        Integer total = 0;
        for (SkiGrouped ski : skis) {
            total += ski.getQuantity();
        }
        return total;
    }
    
    public Ski getRandomSki() {
        return skis.get(random.nextInt(skis.size())).getSki();
    }
}
