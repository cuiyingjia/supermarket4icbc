package vo.base;

public class Fruit {

    private Double discount = 1.0;//折扣

    private Integer price = 0;//原价

    private Integer num = 0;//数量

    public static final Double INIT_DISCOUNT = 1.0;

    protected Fruit(){
    }
    protected Fruit(Integer price){
        this.setPrice(price);
    }
    protected Fruit(Integer price, Double discount){
        this.setPrice(price);
        this.setDiscount(discount);
    }
    protected Fruit (Integer price,Double discount, Integer num){
        this.setPrice(price);
        this.setDiscount(discount);
        this.setNum(num);
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
