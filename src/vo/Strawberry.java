package vo;

import vo.base.Fruit;

public class Strawberry extends Fruit {
    private String name = "草莓";

    public Strawberry (Integer price){
        super(price);
    }
    public Strawberry (Integer num, Double discount){
        super(num,discount);
    }

    public Strawberry (Integer price,Double discount, Integer num){
        super(price,discount,num);
    }
    public String getName() {
        return name;
    }
}
