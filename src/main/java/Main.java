import Persons.Buyer.Buyer;
import Persons.Staff.Seller;
import Products.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Products products = new Products();
        Seller seller = new Seller("Елена", "Торгариан", "vse.prodam@protein.ru", "+7-(111)-154-12-22");
        Buyer buyer = new Buyer("Денис", "Знобишин", "znobishindi@yandex.ru", "+7-(000)-111-22-33");
        buyer.setWallet(5000.0);
        Scanner sc = new Scanner(System.in);
        products.addStartProductToMap();
        System.out.println("""
                Добро пожаловать в наш магазин спортивного питания!
                У нас самый большой ассортимент товаров!
                """);
        while (true) {
            System.out.println("Предлагаем Вам ознакомиться с категориями и выбрать интересующую (Необходимо ввести номер, для выхода из программы введите -1");
            products.printProductCategory();
            int choice = sc.nextInt();
            if (choice == -1) {
                System.out.println("Спасибо, что зашли! Всего хорошего!");
                break;
            }
            switch (choice) {
                case 1 -> {
                    while (true) {
                        products.printProductList(ProductsType.BCAA);
                        choice = sc.nextInt();
                        if (choice == -1) {
                            break;
                        } else if (choice >= 1 && choice <= products.getNumberOfProductsInTheCategory(ProductsType.BCAA)) {
                            buyer.addProductToProductsBasket(products.getProductMap().get(ProductsType.BCAA), choice, sc);
                        } else {
                            System.out.println("У нас пока нет товара под таким номером, попробуйте снова");
                        }
                    }
                }
                case 2 -> ProductsType.BCAA.getProductsTypeInformation();
                case 3 -> {
                    while (true) {
                        products.printProductList(ProductsType.PROTEIN);
                        choice = sc.nextInt();
                        if (choice == -1) {
                            break;
                        } else if (choice >= 1 && choice <= products.getNumberOfProductsInTheCategory(ProductsType.PROTEIN)) {
                            buyer.addProductToProductsBasket(products.getProductMap().get(ProductsType.PROTEIN), choice, sc);
                        } else {
                            System.out.println("У нас пока нет товара под таким номером, попробуйте снова");
                        }
                    }
                }
                case 4 -> ProductsType.PROTEIN.getProductsTypeInformation();
                case 5 -> {
                    while (true) {
                        products.printProductList(ProductsType.GAINER);
                        choice = sc.nextInt();
                        if (choice == -1) {
                            break;
                        } else if (choice >= 1 && choice <= products.getNumberOfProductsInTheCategory(ProductsType.GAINER)) {
                            buyer.addProductToProductsBasket(products.getProductMap().get(ProductsType.GAINER), choice, sc);
                        } else {
                            System.out.println("У нас пока нет товара под таким номером, попробуйте снова");
                        }
                    }
                }
                case 6 -> ProductsType.GAINER.getProductsTypeInformation();
                case 7 -> {
                    while (true) {
                        products.printProductList(ProductsType.CREATINE);
                        choice = sc.nextInt();
                        if (choice == -1) {
                            break;
                        } else if (choice >= 1 && choice <= products.getNumberOfProductsInTheCategory(ProductsType.CREATINE)) {
                            buyer.addProductToProductsBasket(products.getProductMap().get(ProductsType.CREATINE), choice, sc);
                        } else {
                            System.out.println("У нас пока нет товара под таким номером, попробуйте снова");
                        }
                    }
                }
                case 8 -> ProductsType.CREATINE.getProductsTypeInformation();
                case 9 -> {
                    while (true) {
                        products.printProductList(ProductsType.VITAMINS);
                        choice = sc.nextInt();
                        if (choice == -1) {
                            break;
                        } else if (choice >= 1 && choice <= products.getNumberOfProductsInTheCategory(ProductsType.VITAMINS)) {
                            buyer.addProductToProductsBasket(products.getProductMap().get(ProductsType.VITAMINS), choice, sc);
                        } else {
                            System.out.println("У нас пока нет товара под таким номером, попробуйте снова");
                        }
                    }
                }
                case 10 -> ProductsType.VITAMINS.getProductsTypeInformation();
                case 11 -> {
                    while (true) {
                        if (buyer.getBasket() == null || buyer.getBasket().size() == 0) {
                            System.out.println("Вы пока не добавили ни одного товара в корзину");
                            break;
                        } else {
                            buyer.printProductsInBasket();
                            System.out.println("""
                                    Что будем делать?
                                    1. Давайте перейдем к оформлению покупок.
                                    2. Пожалуй, продолжим покупки
                                    3. Хочу удалить товар из корзины""");
                            choice = sc.nextInt();
                            if (choice == 2) {
                                break;
                            } else if (choice == 1) {
                                if (buyer.offerDiscountCard(sc)) {
                                    if (buyer.makePurchaseWithDiscount(sc)) {
                                        seller.printReceipt(buyer);
                                    }
                                } else {
                                    if (buyer.makePurchaseWithOutDiscount()) {
                                        seller.printReceipt(buyer);
                                    }
                                }
                                break;
                            } else if (choice == 3) {
                                while (true) {
                                    System.out.println("Введите номер товара, который хотите удалить из корзины");
                                    buyer.printProductsInBasket();
                                    choice = sc.nextInt();
                                    if (choice > buyer.getBasket().size() || choice < 1) {
                                        System.out.println("У Вас в корзине нет товара с таким номером");
                                    } else {
                                        buyer.deleteProductFromBasket(choice - 1);
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("Вы что-то не то ввели)) Попробуйте снова");
                            }
                        }
                    }
                }
            }
        }
    }
}
