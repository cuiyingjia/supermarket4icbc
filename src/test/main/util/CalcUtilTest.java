package main.util;

import vo.Fruit;
import util.CalcUtil;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

class CalcUtilTest {

    @org.junit.jupiter.api.Test
     void test() {

        Integer applePrice = 8;
        Integer strawBerryPrice = 13;
        Integer mangoPrice = 20;
        Double discount = 0.8;
        Integer appleNum = 12;
        Integer strawBerryNum = 13;
        Integer mangoNum = 14;

        System.out.println("苹果的价格是"+applePrice+"，购买苹果的数量是："+appleNum);
        System.out.println("草莓的价格是"+strawBerryPrice+"，购买草莓的数量是："+strawBerryNum);
        System.out.println("芒果的价格是"+mangoPrice+"，购买芒果的数量是："+mangoNum);

        /* 1、有一家超市，出售苹果和草莓。其中苹果 8 元/斤，草莓 13 元/斤。
        现在顾客 A 在超市购买了若干斤苹果和草莓，需要计算一共多少钱？
        请编写函数，对于 A 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。*/
        Fruit apple = new Fruit("苹果",applePrice);
        Fruit strawberry = new Fruit("草莓",strawBerryPrice);
        apple.setNum(appleNum);
        strawberry.setNum(strawBerryNum);

        List<Fruit> customerA = new ArrayList<>();
        customerA.add(apple);
        customerA.add(strawberry);
        //商品总价A
        Double sumA = CalcUtil.getSumPrice(customerA);
        Double manualA = ((applePrice * appleNum) + (strawBerryPrice * strawBerryNum)) * 1.0;//手动验证计算结果
        Assertions.assertEquals(new Formatter().format("%.2f",manualA).toString(),new Formatter().format("%.2f",sumA).toString());
        System.out.println("A顾客商品总价："+sumA);


         /* 2、超市增加了一种水果芒果，其定价为 20 元/斤。
        现在顾客 B 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
        请编写函数，对于 B 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。*/
        Fruit mango = new Fruit("芒果",mangoPrice);
        mango.setNum(mangoNum);
        List<Fruit> customerB = new ArrayList<>();
        customerB.add(apple);
        customerB.add(strawberry);
        customerB.add(mango);
        //商品总价B
        Double sumB = CalcUtil.getSumPrice(customerB);

        Double manualB = ((applePrice * appleNum) + (strawBerryPrice * strawBerryNum) + (mangoPrice * mangoNum)) * 1.0;//手动验证计算结果
        Assertions.assertEquals(new Formatter().format("%.2f",manualB).toString(),new Formatter().format("%.2f",sumB).toString());
        System.out.println("B顾客商品总价："+sumB);



         /* 3、超市做促销活动，草莓限时打 8 折。
        现在顾客 C 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
        请编写函数，对于 C 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。*/
        strawberry.setDiscount(discount);
        List<Fruit> customerC = new ArrayList<>();
        customerC.add(apple);
        customerC.add(strawberry);
        customerC.add(mango);
        //商品总价C
        Double sumC = CalcUtil.getSumPrice(customerC);

        Double manualC = (applePrice * appleNum) + (strawBerryPrice * strawBerryNum) * discount + (mangoPrice * mangoNum);//手动验证计算结果
        Assertions.assertEquals(new Formatter().format("%.2f",manualC).toString(),new Formatter().format("%.2f",sumC).toString());
        System.out.println("C顾客商品总价："+sumC);



         /* 4、促销活动效果明显，超市继续加大促销力度，购物满 100 减 10 块。
        现在顾客 D 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
        请编写函数，对于 D 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。*/
        List<Fruit> customerD = new ArrayList<>();
        customerD.add(apple);
        customerD.add(strawberry);
        customerD.add(mango);
        //商品总价D
        Double preSumD = CalcUtil.getSumPrice(customerD);
        Double sumD = CalcUtil.promoteRule(preSumD,100.0,10.0);

        Double preManualD = manualC;//手动验证计算结果
        Assertions.assertEquals(new Formatter().format("%.2f",preManualD).toString(),new Formatter().format("%.2f",preSumD).toString());
        System.out.println("D顾客商品优惠前总价："+ preSumD +"，优惠后总价："+ sumD);


    }

}
