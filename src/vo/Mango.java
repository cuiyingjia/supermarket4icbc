package vo;

import vo.base.Fruit;


public class Mango extends Fruit {

    private String name = "芒果";


    public Mango(Integer price){
        super(price);
    }

    public Mango(Integer num, Double discount){
        super(num,discount);
    }

    public Mango(Integer price, Double discount, Integer num){
        super(price,discount,num);
    }

    public String getName() {
        return name;
    }
}
