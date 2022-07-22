package Shop;

import Shop.Products.Product;

public class Informer {

    public static void InformerBuy(Buyer buyer)
    {
        System.out.printf("Buy complete!\nYour balance: %.2f\n\n", buyer.getWallet().floatValue());
    }

    public static void InformerAddBasket(Product product)
    {
        System.out.printf("Product %s, price %.2f p. was added you basket\n", product.getTitleProduct(),product.getPrice().floatValue());
    }

    public static void InformerRemoveBasket(Product product)
    {
        System.out.printf("Product %s removed you basket\n", product.getTitleProduct());
    }

}
