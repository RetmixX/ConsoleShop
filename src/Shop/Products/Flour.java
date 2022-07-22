package Shop.Products;

import java.math.BigDecimal;

public class Flour extends Product {

    private float weight;

    public Flour(String titleProduct, String producer, BigDecimal price, float weight)
    {
        super(titleProduct, producer, price);
        this.weight = weight;
    }

    @Override
    public String ShowInfoProduct() {
        return String.format("<>%s<>" +
                "\nProducer: [%s]" +
                "\nWeight: [%.2f]"+
                "\nPrice: [%.2f]" +
                "\nDiscount price: [%.2f]" +
                "\n<>%s<>\n\n", this.getTitleProduct(), this.getProducer(), weight, this.getPrice().floatValue(), this.Discount().floatValue(), this.getTitleProduct());
    }
}
