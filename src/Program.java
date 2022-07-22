import Shop.Buyer;
import Shop.ConsoleInterface;
import Shop.Informer;
import Shop.Products.*;

import java.math.BigDecimal;
import java.util.Scanner;

/*
    Информация о пользователе - buyer.toString();
    Список товаров - switch

 */

public class Program {

    public static void main(String[] args)
    {
        ConsoleInterface shop = new ConsoleInterface(LoadProduct(), new Buyer("Andrey", "2813.93813.13", new BigDecimal(1000)));
        shop.Run();
    }

    private static Product[] LoadProduct()
    {
        return new Product[]{
                new Drinkable("Pepsi", "Pepsi Company", new BigDecimal(120.33), 2.0f,"Boutle"),
                new Flour("White bread", "Andrey Company", new BigDecimal(34.20),0.234f),
                new Meat("Sosiski", "NONE", new BigDecimal(180.31), "Pork", 0.5f),
                new Snacks("LAYS", "Lays Company", new BigDecimal(99.99), "Package", 0.345f),
                new Sweet("Chocolate Milka", "NONE", new BigDecimal(174.93), 0.323f)
        };
    }
}
