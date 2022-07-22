package Shop.Products;

import java.math.BigDecimal;

public class Meat extends Product{

    private String typeMeat;
    private float weight;

    public Meat(String titleProduct, String producer, BigDecimal price, String typeMeat, float weight)
    {
        super(titleProduct, producer, price);
        this.typeMeat = typeMeat;
        this.weight = weight;
    }

    @Override
    public String ShowInfoProduct() {
        return String.format("<>%s<>" +
                "\nMeat: [%s]"+
                "\nProducer: [%s]" +
                "\nWeight: [%.2f]"+
                "\nPrice: [%.2f]" +
                "\nDiscount price: [%.2f]" +
                "\n<>%s<>\n\n", this.getTitleProduct(), typeMeat, this.getProducer(), weight, this.getPrice().floatValue(), this.Discount().floatValue(), this.getTitleProduct());
    }
}
