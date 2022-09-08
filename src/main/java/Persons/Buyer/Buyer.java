//S - принцип единственной ответственности(Single Responsibility Principle)
// Класс должен выполнять только те функции, для которых он логически предназначен
// Класс Buyer как раз реализует только эти функции (хотя тут есть спорные моменты)
package Persons.Buyer;


import Persons.Human;
import Persons.Staff.Storekeeper;
import Products.Product;

import java.util.*;
//I- принцип сегрегации (разделения) интерфейса(Interface Segregation Principle)
// Много интерфейсов, специально предназначенных для клиентов, лучше, чем один интерфейс общего назначения.
// Класс Buyer имплементирует несколько интерфейсов, содержащих методы, несущие разную смысловую нагрузку
public class Buyer extends Human implements BuyersActionsWithDiscountCard, BuyersActionsWithProductBasket, BuyersActionMakePurchase {
    protected double wallet;
    protected Map<Boolean, Double> discountCard = new HashMap<>();
    protected String address;

    public List<Product> getBasket() {
        return basket;
    }

    protected List<Product> basket = new ArrayList<>();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Buyer(String name, String lastName, String eMail, String phoneNumber) {
        super(name, lastName, eMail, phoneNumber);

    }

    public String getName() {
        return name + " " + lastName;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public Map<Boolean, Double> getDiscountCard() {
        return discountCard;
    }


    @Override
    public void addProductToProductsBasket(List<Product> product, int productNumber, Scanner sc) {
        if (product.get(productNumber - 1).getQuantity() == 0) {
            System.out.println("К сожалению, выбранного товара сейчас нет в наличии...Но не отчаивайтесь! Вы можете заказать его сейчас, и Вам доставят его прямо домой!\n" +
                    "Желаете заказать?\n" +
                    "1. Да, я хочу заказать!\n" +
                    "2. Нет, не нужно. (вернуться к выбору аналогов");
            int choice = sc.nextInt();
            if (choice == 2) {
                System.out.println("Переходим к выбору аналогов");
            } else if (choice == 1) {
                Storekeeper.orderProduct(product, productNumber - 1);
                basket.add(product.get(productNumber - 1));
                int quantity = product.get(productNumber - 1).getQuantity();
                quantity--;
                product.get(productNumber - 1).setQuantity(quantity);
            } else {
                System.out.println("Вы ввели что то не то))) Возвращаем Вас к выбору аналогов");
            }
        } else {
            basket.add(product.get(productNumber - 1));
            int quantity = product.get(productNumber - 1).getQuantity();
            quantity--;
            product.get(productNumber - 1).setQuantity(quantity);
            System.out.println("Товар добавлен в корзину");
        }
    }

    @Override
    public void addDiscountCard() {
        if (discountCard.containsKey(true)) {
            System.out.println("У Вас уже есть дисконтная карта");
        } else {
            discountCard.put(true, 0.0);
            System.out.println("Дисконтная карта успешно добавлена");
        }
    }

    @Override
    public void addScoresToDiscountCard(double scores) {
        discountCard.computeIfPresent(true, (k, v) -> v + scores);
    }

    @Override
    public void deductScoresFromDiscountCard(double scores) {
        discountCard.computeIfPresent(true, (k, v) -> v - scores);
    }

    // Здесь не используется Magic, вместо этого, в итерации применяется размер ArrayList (basket.size())
    @Override
    public double getPriceOfProductsInBasket() {
        double price = 0;
        for (int i = 0; i < basket.size(); i++) {
            price += basket.get(i).getPrice();
        }
        return price;
    }

    // Здесь специально создан метод, выводящий в консоль товары в корзине (принцип DRY)
    @Override
    public void printProductsInBasket() {
        for (int i = 0; i < basket.size(); i++) {
            System.out.println((i + 1) + ". " + basket.get(i).toString() + "Цена товара: " + basket.get(i).getPrice() + "руб.");
        }
        System.out.println("У Вас " + basket.size() + " товара(ов) на общую сумму " + getPriceOfProductsInBasket() + " руб.");
    }

    @Override
    public boolean offerDiscountCard(Scanner sc) {
        boolean b = false;
        while (true) {
            if (discountCard.containsKey(true)) {
                b = true;
                break;
            } else {
                System.out.println("У Вас еще нет нашей дисконтной карты. Желаете завести?\n" +
                        "(После совершения покупки на дисконтную карту начисляются баллы в размере 10% от суммы покупки. 1 балл = 1 рубль\n" +
                        "Никаких ограничений нет, можете полностью оплатить покупку баллами\n" +
                        "1. Конечно!!!\n" +
                        "2. Нет(((");
                int choice = sc.nextInt();
                if (choice == 2) {
                    System.out.println("Очень жаль... Переходим к оплате.");
                    break;
                } else if (choice == 1) {
                    addDiscountCard();
                    b = true;
                    break;
                } else {
                    System.out.println("Вы ввели что-то не то))) Попробуйте снова");
                }
            }
        }
        System.out.println("Напомню, что у Вас в корзине " + basket.size() + " товара(ов) на общую сумму " + getPriceOfProductsInBasket() + " руб.");
        return b;
    }

    @Override
    public boolean makePurchaseWithOutDiscount() {
        double price = getPriceOfProductsInBasket();
        boolean b = true;
        if (wallet < price) {
            System.out.println("К сожалению, у Вас недостаточно средств для оплаты всех покупок. " +
                    "Рекомендую вернуться в корзину и удалить часть товаров");
            b = false;
        } else {
            setWallet(wallet - price);
            System.out.println("Сумма Вашей покупки составила " + price + " руб.");
            basket.clear();
        }
        return b;
    }

    @Override
    public boolean makePurchaseWithDiscount(Scanner sc) {
        double price = getPriceIncludingDiscount();
        boolean b = true;
        while (true) {
            System.out.println("На Вашей дисконтной карте " + discountCard.get(true) + " балл(ов)\n" +
                    "Если спишем баллы, то сумма Вашей покупки составит " + price + " руб. Дополнительные баллы не будут начислены\n" +
                    "Если не будем списывать, то Вам будет начислено " + (getPriceOfProductsInBasket() * 0.1) + " балл(ов)\n" +
                    "1. Давайте спишем\n" +
                    "2. Нет, лучше покоплю");
            int choice = sc.nextInt();
            if (choice == 1) {
                if (wallet < price) {
                    System.out.println("К сожалению, у Вас недостаточно средств для оплаты всех покупок даже с учетом баллов. Рекомендую вернуться в корзину и удалить часть товаров");
                    b = false;
                    break;
                } else {
                    setWallet(wallet - price);
                    if (price == 0) {
                        System.out.println("С Вашей дисконтной карты было списано " + getPriceOfProductsInBasket() + "балл(ов). Сумма покупки составила " + price + " руб.");
                        deductScoresFromDiscountCard(getPriceOfProductsInBasket());
                        System.out.println("На Вашей карте осталось " + discountCard.get(true) + " балл(ов).");
                        basket.clear();
                        break;
                    } else {
                        System.out.println("С Вашей дисконтной карты было списано " + discountCard.get(true) + " балл(ов). Сумма покупки составила " + price + " руб.");
                        deductScoresFromDiscountCard(discountCard.get(true));
                        System.out.println("На Вашей карте осталось " + discountCard.get(true) + " баллов.");
                        basket.clear();
                        break;
                    }
                }
            } else if (choice == 2) {
                price = getPriceOfProductsInBasket();
                if (wallet < price) {
                    System.out.println("К сожалению, у Вас недостаточно средств для оплаты всех покупок. " +
                            "Рекомендую вернуться в корзину и удалить часть товаров");
                    b = false;
                    break;
                } else {
                    setWallet(wallet - price);
                    addScoresToDiscountCard(price * 0.1);
                    System.out.println("Сумма Вашей покупки составила " + price + " руб. На дисконтную карту начислено "
                            + (price * 0.1) + " балл(ов). После покупки на ней " + discountCard.get(true) + " балл(ов).");
                    basket.clear();
                    break;
                }
            } else {
                System.out.println("Вы ввели что-то не то))) Попробуйте снова");
            }
        }
        return b;
    }

    @Override
    public void deleteProductFromBasket(int number) {
        basket.remove(number);
        System.out.println("Товар успешно удален из корзины");
    }

    @Override
    public double getPriceIncludingDiscount() {
        double price = 0;
        if (getPriceOfProductsInBasket() > discountCard.get(true)) {
            price = getPriceOfProductsInBasket() - discountCard.get(true);
        } else {
        }
        return price;
    }
}
