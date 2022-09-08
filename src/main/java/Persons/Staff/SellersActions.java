package Persons.Staff;

import Persons.Buyer.Buyer;
import Products.*;

public interface SellersActions {
    public void sayHello();
    public int sendRequestToTheWarehouse(int productNumber, Products products, ProductsType productsType);
    public void ArrangeDelivery(String date, Buyer buyer);
    public void printReceipt(Buyer buyer);
}
