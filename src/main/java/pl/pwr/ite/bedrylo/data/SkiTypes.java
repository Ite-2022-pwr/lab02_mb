package pl.pwr.ite.bedrylo.data;

public enum SkiTypes {
    SLALOM("Slalom"),
    GIGANT("Gigant"),
    RACE("Race"),
    ALLMOUNTAIN("AllMountain"),
    CARVING("Carving");
    
    private final String typeName;
    
    SkiTypes(String typeName) {
        this.typeName = typeName;
    }
    
    public String getTypeName() {
        return typeName;
    }
    
    public static SkiTypes getSkiType(String typeName) {
        for (SkiTypes skiType : SkiTypes.values()) {
            if (skiType.getTypeName().equals(typeName)) {
                return skiType;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return typeName;
    }
    
    
}
