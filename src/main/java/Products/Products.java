package Products;

import java.util.*;


public class Products {
    protected Map<ProductsType, List<Product>> productMap;

    public Map<ProductsType, List<Product>> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductsType, List<Product>> productMap) {
        this.productMap = productMap;
    }

    public Products() {
        productMap = new TreeMap<>();
    }

    public String getProductsManufacturer(String productsType, int productsNumber) {
        return productMap.get(productsType).get(productsNumber).getManufacturer();
    }

    public String getProductsCountyOfOrigin(String productsType, int productsNumber) {
        return productMap.get(productsType).get(productsNumber).getCountryOfOrigin();
    }

    public String getProductsContainer(String productsType, int productsNumber) {
        return productMap.get(productsType).get(productsNumber).getContainer();
    }

    public double getProductsPrice(String productsType, int productsNumber) {
        return productMap.get(productsType).get(productsNumber).getPrice();
    }

    public String getProductsReleaseForm(String productsType, int productsNumber) {
        return productMap.get(productsType).get(productsNumber).getReleaseForm();
    }

    public void addStartProductToMap() {
        List<Product> bcaa = new ArrayList<>();
        bcaa.add(new Product("BCAA Electro", "Fit-RX", "Россия", "300 грамм", 2700.00, "Порошок", "as123sdad", 1));
        bcaa.add(new Product("BCAA 2:1:1", "Prime Kraft", "Россия", "150 грамм", 690.00, "Порошок", "qwqwd734df", 4));
        bcaa.add(new Product("BCAA 2:1:1", "Prime Kraft", "Россия", "150 грамм", 1600.00, "Капсулы", "asdffasdc3", 2));
        productMap.put(ProductsType.BCAA, bcaa);

        List<Product> protein = new ArrayList<>();
        protein.add(new Product("Whey Protein Power", "PowerPRO", "Россия", "1000 грамм", 2990.00, "Порошок", "sadacy46723", 3));
        protein.add(new Product("R1 Whey Blend", "R1", "США", "920 грамм", 4290.00, "Порошок", "yugw73gf2", 7));
        protein.add(new Product("Fast Whey Protein", "Steel Power", "Россия", "900 грамм", 2690.00, "Порошок", "332rgfw", 0));
        productMap.put(ProductsType.PROTEIN, protein);

        List<Product> gainer = new ArrayList<>();
        gainer.add(new Product("Excellent Mass 5000", "Geon", "Россия", "2720 грамм", 3200.00, "Порошок", "sadfiwe3743r5", 0));
        gainer.add(new Product("Mutant Mass", "Mutant", "Канада", "2720 грамм", 4990.00, "Порошок", "y7g23rf7gdhgds", 3));
        gainer.add(new Product("ISO MASS GAINER", "Prime Kraft", "Россия", "1500 грамм", 2450.00, "Порошок", "u83hfws37fd", 4));
        productMap.put(ProductsType.GAINER, gainer);

        List<Product> creatine = new ArrayList<>();
        creatine.add(new Product("BSN Creatine", "BSN", "США", "309 грамм", 890.00, "Порошок", "iwhdqcxq22", 0));
        creatine.add(new Product("Creatine Monohydrate", "6PAK Nutrition", "Польша", "500 грамм", 1590.00, "Порошок", "sdfw4334gh3hdf", 2));
        creatine.add(new Product("TriNitroCreatine", "SIBERIAN NUTROGUNZ", "Россия", "225 грамм", 789.00, "Порошок", "klcbew87123", 5));
        productMap.put(ProductsType.CREATINE, creatine);

        List<Product> vitamins = new ArrayList<>();
        vitamins.add(new Product("Гиалуроновая кислота", "Geon", "Россия", "300 милиграммов, 60 капсул", 890.00, "Капсулы", "weoweb64376", 7));
        vitamins.add(new Product("GCM JOINT", "Fitness Formula", "Россия", "90 таблеток", 1090.00, "Таблетки", "dsafef345", 6));
        vitamins.add(new Product("Collagen", "BIOVEA", "США", "750 мг, 120 капсул", 1125.00, "Капсулы", "asdfwf3443hg", 1));
        productMap.put(ProductsType.VITAMINS, vitamins);
    }

    public void printProductCategory() {
        int n = 1;
        for (ProductsType category : productMap.keySet()) {
            System.out.println(n + ". " + category.name());
            n++;
            System.out.println(n + ". " + "Посмотреть информацию о " + category.name());
            n++;
        }
        System.out.println(n + ". " + "Перейти в корзину");
    }

    public void printProductList(ProductsType category) {
        List<Product> productList = productMap.get(category);
        System.out.println("В выбранном разделе присутствуют следующие товары:");
        for (Product product : productList) {
            System.out.println((productList.indexOf(product) + 1) + " . " + product.toString() + " Цена за единицу:" +
                    product.getPrice() + " руб. " + "Товара в наличии: " + product.getQuantity() + " шт.");
        }
        System.out.println("Введите номер товара для добавления его в корзину, либо введите -1 для возврата в предыдущее меню.");
    }
    public int getNumberOfProductsInTheCategory(ProductsType category){
        return productMap.get(category).size();
    }
}