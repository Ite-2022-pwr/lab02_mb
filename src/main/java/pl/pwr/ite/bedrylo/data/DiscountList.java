package pl.pwr.ite.bedrylo.data;

import java.util.HashMap;

public abstract class DiscountList {
    private static HashMap<Character, Integer> discountList = new HashMap<>();
    
    public HashMap<Character, Integer> getDiscountList() {
        return discountList;
    }
    
    public void setDiscountList(HashMap<Character, Integer> discountList) {
        discountList = discountList;
    }
    
    public static void addDiscount(Character key, Integer value) {
        DiscountList.discountList.put(key, value);
    }
    
    public static Integer getDiscount(Character key) {
        return discountList.get(key);
    }
}
