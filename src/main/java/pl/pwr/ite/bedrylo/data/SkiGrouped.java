package pl.pwr.ite.bedrylo.data;

public class SkiGrouped {
    private Integer quantity;
    
    private Ski ski;
    
    public SkiGrouped(Ski ski, int quantity) {
        this.ski = ski;
        this.quantity = quantity;
    }
    
    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public Ski getSki() {
        return this.ski;
    }
    
    @Override
    public String toString() {
        return ski.toString() + " " + quantity;
    }
}
