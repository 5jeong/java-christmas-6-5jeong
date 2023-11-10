package christmas.domain;

public enum Menu {
    양송이수프("Appetizer", 6_000),
    타파스("Appetizer", 5_500),
    시저샐러드("Appetizer", 8_000),
    티본스테이크("MainDish", 55_000),
    바비큐립("MainDish", 54_000),
    해산물파스타("MainDish", 35_000),
    크리스마스파스타("MainDish", 25_000),
    초코케이크("Dessert", 15_000),
    아이스크림("Dessert", 5_000),
    제로콜라("Drink", 3_000),
    레드와인("Drink", 60_000),
    샴페인("Drink", 25_000);

    private final String menuType;
    private final int price;

    Menu(String menuType, int price) {
        this.menuType = menuType;
        this.price = price;
    }

    public String getMenuType() {
        return menuType;
    }

    public int getPrice() {
        return price;
    }
}
