package pl.pwr.ite.bedrylo.data;

import java.util.HashMap;

public abstract class DiscountList {
    private static HashMap<Character, Integer> discountList = new HashMap<>();
    
    public static void addDiscount(Character key, Integer value) {
        DiscountList.discountList.put(key, value);
    }
    
    public static Integer getDiscount(Character key) {
        return discountList.get(key);
    }
}
