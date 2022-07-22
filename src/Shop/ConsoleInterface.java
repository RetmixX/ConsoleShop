package Shop;

import Shop.Products.Product;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleInterface {

    private Product[] products;
    private Buyer buyer;

    public ConsoleInterface(Product[] products, Buyer buyer)
    {
        this.products = products;
        this.buyer = buyer;
    }

    public void Run()
    {
        Interface();
    }

    private void Interface()
    {
        LocalDate date = LocalDate.now();
        System.out.printf(Locale.ENGLISH,"Date: %td %tB %tY year\n", date, date, date);
        System.out.printf("Hello, %s, your balance - %.2f\n", buyer.getName(), buyer.getWallet().floatValue());
        Scanner in = new Scanner(System.in);
        String command;
        while (true)
        {
            System.out.print(":> ");
            command = in.next();
            if (command.equals("/exit")) break;

            switch (command)
            {
                case "/profile":
                {
                    System.out.println(buyer.toString());
                    break;
                }

                case "/shop":
                {
                    ShowProducts(products);
                    break;
                }

                case "/basket":
                {
                    ShowBasket(buyer);
                    break;
                }

                case "/addBasket":
                {
                    System.out.print("Number product: ");
                    int id = in.nextInt();
                    if (!(id>=0&&products.length>id))
                    {
                        System.out.println("Product not found!");
                        break;
                    }

                    buyer.AddProduct(products[id]);
                    Informer.InformerAddBasket(products[id]);
                    break;
                }

                case "/removeBasket":
                {
                    System.out.print("Id product: ");
                    int id = in.nextInt();
                    if (!(0<=id&&id<=buyer.getBasket().length))
                    {
                        System.out.println("Position not found!");
                        break;
                    }

                    if (buyer.RemoveProduct(products[id])) Informer.InformerRemoveBasket(products[id]);
                    else System.out.println("ERROR: Remove product on basket is failed");

                    break;
                }

                case "/buy":
                {
                    if (buyer.Buy()) Informer.InformerBuy(buyer);
                    else System.out.println("ERROR: Buy is failed!");
                    break;
                }

                case "/help":
                {
                    ShowHelp();
                    break;
                }

                case "/infoProduct":
                {
                    for(var i : products)
                    {
                        System.out.println(i.ShowInfoProduct());
                    }
                }

                default:
                {
                    System.out.println("ERROR: Command not found!");
                    break;
                }
            }
        }

        System.out.println("Exit...");
    }

    private void ShowProducts(Product[] products)
    {
        for (var i = 0; i<products.length;i++)
        {
            System.out.printf("[%d] - %s\n", i, products[i].getTitleProduct());
        }
    }

    private void ShowBasket(Buyer buyer)
    {
        System.out.println("Basket");
        for (var i = 0; i<buyer.getBasket().length; i++)
        {
            if (buyer.getBasket()[i]!=null) System.out.printf("Position: [%d] - Product: [%s]\n", i, buyer.getBasket()[i].getTitleProduct());
        }
    }

    private void ShowHelp(){
        System.out.println("/exit\n/profile\n/shop\n/basket\n/addBasket\n/removeBasket\n/buy\n/infoProduct\n/help\n");
    }
}
