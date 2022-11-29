package vo;

import vo.base.Fruit;

public class Apple extends Fruit {


    private String name = "苹果";

    public Apple (Integer price){
        super(price);
    }
    public Apple (Integer price, Double discount){
        super(price,discount);
    }

    public Apple (Integer price,Double discount, Integer num){
        super(price,discount,num);
    }

    public String getName() {
        return name;
    }

}
