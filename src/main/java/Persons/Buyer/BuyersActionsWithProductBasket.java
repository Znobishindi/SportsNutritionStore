package Persons.Buyer;

import Products.Product;

import java.util.List;
import java.util.Scanner;

public interface BuyersActionsWithProductBasket {

    public void addProductToProductsBasket(List<Product> product, int productNumber, Scanner sc);
    public double getPriceOfProductsInBasket();
    public void printProductsInBasket();
    public void deleteProductFromBasket(int number);
}
