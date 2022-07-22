package Shop.Products;

import java.math.BigDecimal;

public class Sweet extends Product {
    private float calories;

    public Sweet(String titleProduct, String producer, BigDecimal price, float calories)
    {
        super(titleProduct, producer, price);
        this.calories = calories;
    }

    @Override
    public String ShowInfoProduct() {
        return String.format("<>%s<>" +
                "\nProducer: [%s]" +
                "\nCalories: [%.3f]" +
                "\nPrice: [%.2f]" +
                "\nDiscount price: [%.2f]"+
                "\n<>%s<>\n\n", this.getTitleProduct(), this.getProducer(), calories, this.getPrice().floatValue(), this.Discount().floatValue(), this.getTitleProduct());
    }

    @Override
    public BigDecimal Discount()
    {
        return this.getPrice().multiply(new BigDecimal(0.1));
    }
}
