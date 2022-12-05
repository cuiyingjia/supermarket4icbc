package main.util;

import main.vo.Fruit;

import java.util.Formatter;
import java.util.List;

public final class CalcUtil {

    public static Double getSumPrice(List<Fruit> fruits){
        Double sumPrice = 0.0;
        if (fruits == null || fruits.isEmpty()){
            return sumPrice;
        }
        for (Fruit fruit: fruits){
            Double preSum  = fruit.getPrice() * fruit.getNum() * fruit.getDiscount();
            sumPrice += preSum;
        }

        return Double.valueOf(new Formatter().format("%.2f",sumPrice).toString());
    }

    public static Double promoteRule(Double preSum, Double baseNum, Double minus) {
        if(preSum > baseNum ){
            Double minusBase = Math.floor(preSum/baseNum);
            preSum -= minusBase * minus;
        }
        return preSum;
    }

}
