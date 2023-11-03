package pl.pwr.ite.bedrylo.misc;

import pl.pwr.ite.bedrylo.data.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FileHandler {
    private static <E> List<E> readFile(String filePath, Function<String, E> mapper) {
        var temporaryList = new ArrayList<E>();
        try {
            var reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                temporaryList.add(mapper.apply(line));
            }
            return temporaryList;
        } catch (IOException exc) {
            exc.printStackTrace();
            throw new RuntimeException("Problem reading file");
        }
    }
    
    public static ArrayList<SkiGrouped> readSkiList(String filePath) {
        return (ArrayList<SkiGrouped>) readFile(filePath, (line -> {
            var skiLine = line.split(",");
            var skiInfo = skiLine[1].split(":");
            Ski ski = new Ski(SkiTypes.getSkiType(skiInfo[0]), Integer.parseInt(skiInfo[1]));
            return new SkiGrouped(ski, Integer.parseInt(skiLine[0]));
        }));
    }
    
    public static void readDiscountList(String filePath) {
        readFile(filePath, (line -> {
            var discountLine = line.split(",");
            DiscountList.addDiscount(discountLine[0].charAt(0), Integer.parseInt(discountLine[1]));
            return null;
        }));
    }
    
    public static void readPreferenceList(String filePath) {
            readFile(filePath, (line -> {
            var preferenceLine = line.split(",");
            var skiList = new ArrayList<Ski>();
            var availablePreferences = preferenceLine[2].split(";");
            for (var preference: availablePreferences){
                var skiInfo = preference.split(":");
                Ski ski = new Ski(SkiTypes.getSkiType(skiInfo[0]), Integer.parseInt(skiInfo[1]));
                skiList.add(ski);
            }
            PreferenceList.addPreference(new PersonalPreference(Integer.parseInt(preferenceLine[0]), skiList, preferenceLine[1].charAt(0)));
            return null;
        }));
    }
    
    public static void saveMatchList(String filePath, MatchList matchList) {
        try {
            var writer = new java.io.FileWriter(filePath);
            writer.write(matchList.toFileString());
            writer.close();
        } catch (IOException exc) {
            exc.printStackTrace();
            throw new RuntimeException("Problem saving file");
        }
    }
    
}
