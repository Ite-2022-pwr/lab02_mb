package pl.pwr.ite.bedrylo.misc;

public abstract class ConfigClass {
    private static String skiListPath = "src/main/java/pl/pwr/ite/bedrylo/resources/wykaz.txt";
    
    private static String preferencesListPath = "src/main/java/pl/pwr/ite/bedrylo/resources/preferences.txt";
    
    private static String discountsListPath = "src/main/java/pl/pwr/ite/bedrylo/resources/znizki.txt";
    
    public static String getSkiListPath() {
        return skiListPath;
    }
    
    public static String getPreferencesListPath() {
        return preferencesListPath;
    }
    
    public static String getDiscountsListPath() {
        return discountsListPath;
    }
}
