package Shop.Products;

import java.math.BigDecimal;

public abstract class Product {

    private String titleProduct;
    private String producer;
    private BigDecimal price;

    public Product(String titleProduct, String producer, BigDecimal price)
    {
        this.titleProduct = titleProduct;
        this.producer = producer;
        this.price = price;
    }

    public String getTitleProduct() {
        return titleProduct;
    }

    public String getProducer() {
        return producer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public abstract String ShowInfoProduct();

    public BigDecimal Discount()
    {
        return price.multiply(new BigDecimal(1));
    }

    @Override
    public boolean equals(Object obj) {

        if (obj==null) return false;
        if(!(obj instanceof Product)) return false;

        return ((Product) obj).titleProduct == this.titleProduct;
    }
}
