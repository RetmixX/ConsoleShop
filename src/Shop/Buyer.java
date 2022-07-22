package Shop;

import Shop.Products.Product;

import java.math.BigDecimal;
import java.util.Objects;

public class Buyer {

    private String name;
    private String address;
    private BigDecimal wallet;

    private Product[] basket = new Product[5];

    public Buyer(String name, String address, BigDecimal wallet)
    {
        this.name = name;
        this.address = address;
        this. wallet = wallet;

    }

    public String getName() {
        return name;
    }

    public BigDecimal getWallet() {
        return wallet;
    }

    public String getAddress() {
        return address;
    }

    public Product[] getBasket() {
        return basket;
    }

    public void AddProduct(Product product)
    {
        for (var i = 0; i<basket.length; i++)
        {
            if (basket[i]==null)
            {
                basket[i] = product;
                return;
            }

        }

        basket = ExtensionBasket(product);
    }

    public boolean RemoveProduct(Product product)
    {
        if (product==null) return false;
        for (var i = 0; i<basket.length; i++)
        {
            if (basket[i]!=null&&(basket[i].equals(product)))
            {
                basket[i] = null;
                basket = CorrectBasket();
                return true;
            }
        }

        return false;
    }

    private Product[] ExtensionBasket(Product product)
    {
        Product[] newBasket = new Product[basket.length+2];

        for (var i = 0; i<basket.length; i++)
        {
            newBasket[i] = basket[i];
        }

        for (var i = 0; i<newBasket.length; i++)
        {
            if (newBasket[i]==null)
            {
                newBasket[i] = product;
                break;
            }
        }

        return newBasket;
    }

    public boolean Buy()
    {
        BigDecimal check = new BigDecimal(0);
        for (var i : basket)
        {
            if(i!=null) check = check.add(i.Discount());
        }

        if(wallet.subtract(check).floatValue()<0) return false;
        if (check.floatValue()==0f) return false;

        wallet = wallet.subtract(check);
        basket = new Product[5];

        return true;

    }

    private Product[] CorrectBasket()
    {
        Product[] newBasket = new Product[basket.length-1];
        for (var i = 0; i<basket.length;i++)
        {
            if (basket[i]!=null) newBasket[i] = basket[i];
        }

        return newBasket;
    }

    @Override
    public String toString()
    {
        return String.format("Name: [%s]\nAddress: [%s]\nWallet: [%.2f]\n\n", name, address, wallet.floatValue());
    }
}
