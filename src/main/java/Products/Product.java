package Products;
public class Product {
    //O - принцип открытости/закрытости(Open Closed Principle)
    // Программные сущности должны быть открыты для расширения, но закрыты для модификации.
    // Здесь представлены защищенные поля, некоторые из которых имеют модификатор final
    protected final String productsName;
    protected final String manufacturer;
    protected final String countryOfOrigin;
    protected final String container;
    protected final String releaseForm;
    protected final String articleNumber;
    protected final double price;
    protected int quantity = 0;



    public Product(String productsName, String manufacturer, String countryOfOrigin, String container, double price, String releaseForm, String articleNumber, int quantity) {
        this.productsName = productsName;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.container = container;
        this.price = price;
        this.releaseForm = releaseForm;
        this.articleNumber = articleNumber;
        this.quantity = quantity;
    }

    public String getProductsName() {
        return productsName;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public String getReleaseForm() {
        return releaseForm;
    }
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public String getContainer() {
        return container;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return  productsName +
                ", производитель: " + manufacturer  +
                ", страна-производитель: " + countryOfOrigin  +
                ", упаковка: " + container + "\n";
    }
}