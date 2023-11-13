package christmas.domain;

import java.util.Map;

public class WeekdayDiscount {

    private static final int DESSERT_DISCOUNT = 2023;
    private static final int NO_DISCOUNT_AMOUNT = 0;
    private static final String DESSERT_MENU_TYPE = "Dessert";

    public int calculateDiscount(DayOfWeek visitDayOfWeek, Map<String, Integer> orderHistory) {
        if (isWeekdayEvent(visitDayOfWeek)) {
            return calculateWeekdayDiscount(orderHistory);
        }
        return NO_DISCOUNT_AMOUNT;
    }

    private boolean isWeekdayEvent(DayOfWeek visitDayOfWeek) {
        return visitDayOfWeek.isWeekday();
    }

    private int calculateWeekdayDiscount(Map<String, Integer> orderHistory) {
        int dessertQuantity = orderHistory.entrySet().stream()
                .filter(entry -> Menu.valueOf(entry.getKey()).getMenuType().equals(DESSERT_MENU_TYPE))
                .mapToInt(Map.Entry::getValue)
                .sum();
        return DESSERT_DISCOUNT * dessertQuantity;
    }

}
