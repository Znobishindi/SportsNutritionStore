package Persons.Staff;

import Persons.Human;
import Products.Product;

import java.util.List;

public class Storekeeper extends Human {
    public Storekeeper(String name, String lastName, String eMail, String phoneNumber) {
        super(name, lastName, eMail, phoneNumber);
    }
    public static void orderProduct(List<Product> product, int productNumber){
        product.get(productNumber).setQuantity(1);
        System.out.println("Товар успешно заказан и добавлен в Вашу корзину");
    }
}
