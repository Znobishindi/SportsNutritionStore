package Persons.Buyer;

import Products.Product;

import java.util.List;
import java.util.Scanner;

public interface BuyersActionsWithDiscountCard {
    public void addDiscountCard();

    public void addScoresToDiscountCard(double scores);

    public void deductScoresFromDiscountCard(double scores);

    public void addProductToProductsBasket(List<Product> product, int productNumber, Scanner sc);

    public boolean offerDiscountCard(Scanner sc);

    public double getPriceIncludingDiscount();

}
