package pl.pwr.ite.bedrylo.data;

public class Ski {
    private final SkiTypes type;
    
    private final Integer length;
    
    public Ski(SkiTypes type, Integer length) {
        this.type = type;
        this.length = length;
    }
    
    public SkiTypes getType() {
        return type;
    }
    
    public Integer getLength() {
        return length;
    }
    
    @Override
    public String toString() {
        return type + " " + length;
    }
}
