package Persons.Staff;

import Persons.Buyer.Buyer;
import Persons.Human;
import Products.*;

public class Seller extends Human implements SellersActions {
    public Seller(String name, String lastName, String eMail, String phoneNumber) {
        super(name, lastName, eMail, phoneNumber);
    }
    public String getName() {
        return name + " " + lastName;
    }

    @Override
    public void sayHello() {
        System.out.println("Добро пожаловать в наш магазин спортивного питания!\n" +
                "У нас самый большой ассортимент товаров!\n" +
                "Предлагаем Вам ознакомиться с категориями и выбрать интересующую (Необходимо ввести номер, для выхода из программы введите -1");
    }

    @Override
    public int sendRequestToTheWarehouse(int productNumber, Products products, ProductsType productsType) {
        return products.getProductMap().get(productsType).get(productNumber).getQuantity();
    }

    @Override
    public void ArrangeDelivery(String date, Buyer buyer) {
        System.out.println("Доставка оформлена на " + date + "\n" + "Адрес доставки: " + buyer.getAddress() + "\n" +
                "Покупатель: " + buyer.getName());
    }

    @Override
    public void printReceipt(Buyer buyer) {
        System.out.println("""
                ++++++++++++++++++++++++++++++++++++++++Ваш чек:++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                ========================================================================================================
                ========================================================================================================""");
        buyer.printProductsInBasket();
        System.out.println("Покупку совершил " + buyer.getName());
        System.out.println("На Вашем счете осталось " + buyer.getWallet() + " руб.");
        if (buyer.getDiscountCard().containsKey(true)){
            System.out.println("На Вашей дисконтной карте осталось " + buyer.getDiscountCard().get(true) + " балл(ов)");
        }
        System.out.println("Вас обслуживал продавец " + getName());
        System.out.println("""
                +++++++++++++++++++++++++++++++++++СПАСИБО ЗА ПОКУПКУ+++++++++++++++++++++++++++++++++++++++++++++++++++
                ========================================================================================================
                ========================================================================================================""");
    }
}
