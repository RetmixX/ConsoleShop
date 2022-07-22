package Shop.Products;

import java.math.BigDecimal;

public class Snacks extends Product{

    private float weight;
    private String descriptionPackage;

    public Snacks(String titleProduct, String producer, BigDecimal price, String DescriptionPackage ,float weight)
    {
        super(titleProduct, producer, price);
        this.descriptionPackage = DescriptionPackage;
        this.weight = weight;
    }

    @Override
    public String ShowInfoProduct() {

        return String.format("<>%s<>" +
                "\nProducer: [%s]" +
                "\nPackaging: [%s]" +
                "\nWeight: [%s]" +
                "\nPrice: [%.2f]" +
                "\nDiscount price: [%.2f]"+
                "\n<>%s<>\n\n", this.getTitleProduct(), this.getProducer(), descriptionPackage, weight, this.getPrice().floatValue(), this.Discount().floatValue(), this.getTitleProduct());
    }
}
