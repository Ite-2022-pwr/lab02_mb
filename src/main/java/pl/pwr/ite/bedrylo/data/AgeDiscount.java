package pl.pwr.ite.bedrylo.data;

public class AgeDiscount {
    
    private Integer age;

    private Integer discount;

    public AgeDiscount(Integer age, Integer discount) {
        this.age = age;
        this.discount = discount;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getDiscount() {
        return discount;
    }
}
