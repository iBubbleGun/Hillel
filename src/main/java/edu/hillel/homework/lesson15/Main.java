package edu.hillel.homework.lesson15;

import edu.hillel.homework.lesson15.stock.Product;
import edu.hillel.homework.lesson15.stock.ProductManager;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // part 1
        ProductManager pm1 = new ProductManager();
        pm1.delimiter(1);
        pm1.add(new Product("Book", 255));
        pm1.add(new Product("Toy", 249));
        pm1.add(new Product("Book", 25));
        pm1.add(new Product("Book", 2));
        pm1.add(new Product("Book", 300));
        List<Product> list1 = pm1.getProductsWithPriceNotLessThen("Book", 250);
        System.out.println("All books with prise more than 250:");
        pm1.printProductsTypeAndPriceOnly(list1);

        // part 2
        ProductManager pm2 = new ProductManager();
        pm2.delimiter(2);
        pm2.add(new Product("Toy", 255.32, true));
        pm2.add(new Product("Book", 25.10, false));
        pm2.add(new Product("Book", 125.00, true)); // discounted (10%) price = 112.50
        pm2.add(new Product("Book", 360.50, true)); // discounted (10%) price = 324.45
        pm2.add(new Product("Book", 175.10, false));
        pm2.add(new Product("Toy", 249.99, true));
        pm2.add(new Product("Book", 750.30, true)); // discounted (10%) price = 675.27
        pm2.add(new Product("Toy", 405.10, true));
        pm2.add(new Product("Book", 145.25, false));
        List<Product> list2 = pm2.getProductsWithDiscount("Book", 10); // discount 10%
        System.out.println("Discounted books with discounted prise:");
        pm2.printProductsWithTypeAndPriceAndDiscount(list2);
        System.out.println("\nOriginal full product list with full prices:");
        pm2.printProductsWithAllFields(pm2.getProductList());

        // part 3
        ProductManager pm3 = new ProductManager();
        pm3.delimiter(3);
        pm3.add(new Product("Toy", 256.32, true));
        pm3.add(new Product("Book", 26.10, false)); // cheapest book
        pm3.add(new Product("Book", 135.00, true));
        pm3.add(new Product("Book", 370.50, true));
        pm3.add(new Product("Book", 185.10, false));
        pm3.add(new Product("Toy", 239.99, true));
        pm3.add(new Product("Book", 740.30, true));
        pm3.add(new Product("Toy", 400.10, true));
        pm3.add(new Product("Book", 155.25, false));
        System.out.println("The cheapest book:");
        System.out.println(pm3.getCheapestProduct("Book"));
        // product type "Computer" doesn't exist - throw NoSuchElementException
//        System.out.println(pm3.getCheapestProduct("Computer"));

        // part 4
        ProductManager pm4 = new ProductManager();
        pm4.delimiter(4);
        pm4.add(new Product("Book", 255.32, true));
        Thread.sleep(20);
        pm4.add(new Product("Toy", 249.45, true));
        Thread.sleep(27); // simulate different adding times
        pm4.add(new Product("Book", 25.10, false));
        Thread.sleep(2); // simulate different adding times
        pm4.add(new Product("Toy", 20.40, false));
        Thread.sleep(5); // simulate different adding times
        pm4.add(new Product("Book", 300.10, true));
        Thread.sleep(15); // simulate different adding times
        pm4.add(new Product("Toy", 23.00, false));
        Thread.sleep(27); // simulate different adding times
        pm4.add(new Product("Toy", 27.35, false));
        Thread.sleep(25); // simulate different adding times
        pm4.add(new Product("Book", 44.15, false)); // will be third on a new list
        Thread.sleep(18); // simulate different adding times
        pm4.add(new Product("Toy", 678.99, true)); // will be second on a new list
        Thread.sleep(32); // simulate different adding times
        pm4.add(new Product("Book", 212.80, false)); // will be first on a new list
        List<Product> list4 = pm4.getThreeLatestProducts();
        System.out.println("Three latest added products:");
        pm4.printProductsWithAllFields(list4);

        // part 5
        ProductManager pm5 = new ProductManager();
        pm5.delimiter(5);
        pm5.add(new Product("Toy", 21.00, true));
        pm5.add(new Product("Book", 116.10, false));
        pm5.add(new Product("Book", 30.00, true)); // this one
        pm5.add(new Product("Book", 70.50, false)); // this one
        pm5.add(new Product("Book", 85.10, false));
        pm5.add(new Product("Toy", 79.99, true));
        pm5.add(new Product("Book", 14.10, true)); // this one
        pm5.add(new Product("Toy", 40.10, true));
        pm5.add(new Product("Book", 153.25, false));
        // total cost = 30.00 + 70.50 + 14.10 = 114.60
        System.out.println("Total cost of all books added in the current year with a price of no more than 75:");
        System.out.println(pm5.calculateTotalCost("Book", 75, LocalDate.now().getYear()) + " UAH");

        // part 6
        ProductManager pm6 = new ProductManager();
        pm6.delimiter(6);
        pm6.add(new Product("Toy", 214.00, true));
        pm6.add(new Product("Book", 156.10, false));
        pm6.add(new Product("Book", 37.00, true));
        pm6.add(new Product("Book", 74.50, false));
        pm6.add(new Product("Book", 86.10, false));
        pm6.add(new Product("Toy", 79.99, true));
        pm6.add(new Product("Book", 144.10, true));
        pm6.add(new Product("Toy", 403.10, true));
        pm6.add(new Product("Book", 153.25, false));
        pm6.add(new Product("Computer", 8660.10, false));
        pm6.add(new Product("Computer", 7999.99, true));
        pm6.add(new Product("Book", 144.10, true));
        pm6.add(new Product("Toy", 403.10, true));
        pm6.add(new Product("Book", 153.25, false));
        pm6.add(new Product("Textile", 86.10, false));
        pm6.add(new Product("Toy", 79.99, true));
        pm6.add(new Product("Textile", 144.10, true));
        pm6.add(new Product("Toy", 403.10, true));
        pm6.add(new Product("Computer", 15390.25, false));

        List<Product> currentProductList = pm6.getProductList();
        Map<String, List<Product>> groupedProducts = pm6.groupProductsByType(currentProductList);

        System.out.println("Grouped products by product type:");
        groupedProducts.forEach((key, value) -> {
            System.out.print("{\n  " + key + ":\n  [\n");
            value.stream()
                    .map((p) -> "   " + p)
                    .forEach(System.out::println);
            System.out.println("  ]\n}");
        });
    }
}
