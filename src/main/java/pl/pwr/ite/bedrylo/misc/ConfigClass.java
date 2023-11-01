package pl.pwr.ite.bedrylo.misc;

public abstract class ConfigClass {
    private static String skiListPath = "src/main/java/pl/pwr/ite/bedrylo/resources/wykaz.txt";
    
    private static String preferencesListPath = "src/main/java/pl/pwr/ite/bedrylo/resources/preferences.txt";
    
    private static String discountsListPath = "src/main/java/pl/pwr/ite/bedrylo/resources/znizki.txt";
    
    private static String resultSavePath = "src/main/java/pl/pwr/ite/bedrylo/resources/result.txt";
    
    private static Integer generationMaxNumber = 0;
    
    private static Integer matchListCount = 0;
    
    private static Integer comparisonAmount = 0;
    
    private static Integer actualGeneration = 0;
    
    public static String getSkiListPath() {
        return skiListPath;
    }
    
    public static void setSkiListPath(String skiListPath) {
        ConfigClass.skiListPath = skiListPath;
    }
    
    public static String getPreferencesListPath() {
        return preferencesListPath;
    }
    
    public static void setPreferencesListPath(String preferencesListPath) {
        ConfigClass.preferencesListPath = preferencesListPath;
    }
    
    public static String getDiscountsListPath() {
        return discountsListPath;
    }
    
    public static void setDiscountsListPath(String discountsListPath) {
        ConfigClass.discountsListPath = discountsListPath;
    }
    
    public static String getResultSavePath() {
        return resultSavePath;
    }
    
    public static void setResultSavePath(String resultSavePath) {
        ConfigClass.resultSavePath = resultSavePath;
    }
    
    public static Integer getGenerationMaxNumber() {
        return generationMaxNumber;
    }
    
    public static void setGenerationMaxNumber(Integer generationMaxNumber) {
        ConfigClass.generationMaxNumber = Math.max(1,generationMaxNumber);
    }
    
    public static Integer getMatchListCount() {
        return matchListCount;
    }
    
    public static void setMatchListCount(Integer matchListCount) {
        ConfigClass.matchListCount = Math.max(1,matchListCount);
    }
    
    public static Integer getComparisonAmount() {
        return comparisonAmount;
    }
    
    public static void setComparisonAmount(Integer comparisonAmount) {
        ConfigClass.comparisonAmount = Math.max(1,comparisonAmount);
    }
    
    public static Integer getActualGeneration() {
        return actualGeneration;
    }
    
    public static void setActualGeneration(Integer actualGeneration) {
        ConfigClass.actualGeneration = actualGeneration;
    }
}
