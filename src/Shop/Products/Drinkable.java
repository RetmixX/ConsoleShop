package Shop.Products;

import Shop.Products.Product;

import java.math.BigDecimal;

public class Drinkable extends Product {

    private float litre;
    private String typePackaging;
    private String colorDrink;

    public Drinkable(String titleProduct, String producer, BigDecimal price, float litre, String typePackaging)
    {
        super(titleProduct, producer, price);
        this.litre = litre;
        this.typePackaging = typePackaging;
    }

    @Override
    public String ShowInfoProduct() {
        return String.format("<>%s<>" +
                "\nProducer: [%s]" +
                "\nPackaging: [%s]" +
                "\nLitre: [%s]" +
                "\nColor drink: [%s]" +
                "\nPrice: [%.2f]" +
                "\nDiscount price: [%.2f]"+
                "\n<>%s<>\n\n", this.getTitleProduct(), this.getProducer(), typePackaging, litre, colorDrink, this.getPrice().floatValue(), this.Discount().floatValue(), this.getTitleProduct());
    }
}
