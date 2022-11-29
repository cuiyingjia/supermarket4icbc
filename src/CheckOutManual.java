import util.CalcUtil;
import util.PromotionRules;
import vo.Apple;
import vo.Mango;
import vo.Strawberry;
import vo.base.Fruit;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class CheckOutManual {


    public static void main(String[] args) throws Exception {
        Integer applePrice = 8;
        Integer strawBerryPrice = 13;
        Integer mangoPrice = 20;
        Double discount = 0.8;

        Scanner sc = new Scanner(System.in);
        System.out.print("苹果的价格是"+applePrice);
        System.out.print("，请输入购买苹果的数量：");
        Integer appleNum = sc.nextInt();
        System.out.print("草莓的价格是"+strawBerryPrice);
        System.out.print("，请输入购买草莓的数量：");
        Integer strawBerryNum = sc.nextInt();
        System.out.print("芒果的价格是是"+mangoPrice);
        System.out.print("，请输入购买芒果的数量：");
        Integer mangoNum = sc.nextInt();
        sc.close();

        /* 1、有一家超市，出售苹果和草莓。其中苹果 8 元/斤，草莓 13 元/斤。
        现在顾客 A 在超市购买了若干斤苹果和草莓，需要计算一共多少钱？
        请编写函数，对于 A 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。*/
        Apple apple = new Apple(applePrice);
        Strawberry strawberry = new Strawberry(strawBerryPrice);
        apple.setNum(appleNum);
        strawberry.setNum(strawBerryNum);

        List<Fruit> customerA = new ArrayList<>();
        customerA.add(apple);
        customerA.add(strawberry);
        //商品总价A
        Double sumA = CalcUtil.getSumPrice(customerA);

        Double manualA = ((applePrice * appleNum) + (strawBerryPrice * strawBerryNum)) * 1.0;//手动验证计算结果
        if (!Double.valueOf(new Formatter().format("%.2f",manualA).toString()).equals(sumA)){
            throw new Exception("A顾客商品总价有误，手动计算值："+manualA+"，自动计算值："+sumA);
        }

        System.out.println("A顾客商品总价："+sumA);


         /* 2、超市增加了一种水果芒果，其定价为 20 元/斤。
        现在顾客 B 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
        请编写函数，对于 B 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。*/
        Mango mango = new Mango(mangoPrice);
        mango.setNum(mangoNum);
        List<Fruit> customerB = new ArrayList<>();
        customerB.add(apple);
        customerB.add(strawberry);
        customerB.add(mango);
        //商品总价B
        Double sumB = CalcUtil.getSumPrice(customerB);

        Double manualB = ((applePrice * appleNum) + (strawBerryPrice * strawBerryNum) + (mangoPrice * mangoNum)) * 1.0;//手动验证计算结果
        if (!Double.valueOf(new Formatter().format("%.2f",manualB).toString()).equals(sumB)){
            throw new Exception("B顾客商品总价有误，手动计算值："+manualB+"，自动计算值："+sumB);
        }

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
        if (!Double.valueOf(new Formatter().format("%.2f",manualC).toString()).equals(sumC)){
            throw new Exception("C顾客商品总价有误，手动计算值："+manualC+"，自动计算值："+sumC);
        }

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
        Double sumD = PromotionRules.getSumFromRule(preSumD,PromotionRules.RULE_001);

        Double preManualD = manualC;//手动验证计算结果
        if (!Double.valueOf(new Formatter().format("%.2f",preManualD).toString()).equals(preSumD)){
            throw new Exception("D顾客商品优惠前总价有误，手动计算值："+preManualD+"，自动计算值："+preSumD);
        }

        System.out.println("D顾客商品优惠前总价："+ preSumD +"，优惠后总价："+ sumD);


    }


}
