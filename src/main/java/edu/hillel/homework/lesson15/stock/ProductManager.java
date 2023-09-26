package edu.hillel.homework.lesson15.stock;

import org.jetbrains.annotations.NotNull;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProductManager {

    private final List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public ProductManager() {
        this.productList = new ArrayList<>();
    }

    public void add(Product product) {
        productList.add(product);
    }

    public List<Product> getProductsWithPriceNotLessThen(String productType, double minProductPrice) {
        return productList.stream()
                .filter((p) -> p.getType().equals(productType) && p.getPrice() > minProductPrice)
                .collect(Collectors.toList());
    }

    public List<Product> getProductsWithDiscount(String productType, double discountValue) {
        return productList.stream()
                .filter((p) -> p.getType().equals(productType) && p.isDiscountApplicable())
                .map((p) -> {
                    double discountedPrice = p.getPrice() * (1 - (discountValue / 100));
                    return new Product(p.getType(), discountedPrice, true);})
                .collect(Collectors.toList());
    }

    public List<Product> getThreeLatestProducts() {
        return productList.stream()
                .sorted(Comparator.comparing(Product::getDateAdded).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public Product getCheapestProduct(String productType) {
        try {
            return productList.stream()
                    .filter((p) -> p.getType().equals(productType))
                    .min(Comparator.comparingDouble(Product::getPrice))
                    .get();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Product [type: \"" + productType + "\"] doesn't exist.");
        }
    }

    public double calculateTotalCost(String productType, double maxPriceValue, int targetYear) {
        return productList.stream()
                .filter((p) -> p.getType().equals(productType)
                        && p.getPrice() <= maxPriceValue
                        && p.getDateAdded().getYear() == targetYear)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public Map<String, List<Product>> groupProductsByType(@NotNull List<Product> productList) {
        return productList.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }

    public void printProductsTypeAndPriceOnly(@NotNull List<Product> productList) {
        int len = productList.size();
        System.out.println("[");
        IntStream.range(0, len).forEach(i -> {
            Product p = productList.get(i);
            System.out.println(
                    "Product{" +
                            "type=\"" + p.getType() + "\", " +
                            "price=\"" + p.getPrice() + " UAH\"" +
                            "}" + ((i < len - 1) ? "," : ""));
        });
        System.out.println("]");
    }

    public void printProductsWithTypeAndPriceAndDiscount(@NotNull List<Product> productList) {
        int len = productList.size();
        System.out.println("[");
        IntStream.range(0, len).forEach(i -> {
            Product p = productList.get(i);
            System.out.println(
                    "Product{" +
                            "type=\"" + p.getType() + "\", " +
                            "price=\"" + p.getPrice() + " UAH\", " +
                            "discountApplicable=\"" + p.isDiscountApplicable() + "\"" +
                            "}" + ((i < len - 1) ? "," : ""));
        });
        System.out.println("]");
    }

    public void printProductsWithAllFields(@NotNull List<Product> productList) {
        int len = productList.size();
        System.out.println("[");
        IntStream.range(0, len).forEach(i -> {
            Product p = productList.get(i);
            System.out.println(
                    "Product{" +
                            "type=\"" + p.getType() + "\", " +
                            "price=\"" + p.getPrice() + " UAH\", " +
                            "discountApplicable=\"" + p.isDiscountApplicable() + "\", " +
                            "dateAdded=\"" + p.getDateAdded().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "\", " +
                            "productId=\"" + p.getProductId() + "\"" + "}" + ((i < len - 1) ? "," : ""));
        });
        System.out.println("]");
    }

    public void delimiter(int homeworkPart) {
        System.out.println("\n"
                .concat("-".repeat(100))
                .concat(" part ")
                .concat(String.valueOf(homeworkPart)));
    }
}
