package christmas.domain;

import java.util.Map;

public class WeekendDiscount {
    private static final int MAIN_DISH_DISCOUNT = 2023;
    private static final int NO_DISCOUNT_AMOUNT = 0;
    private static final String MAIN_MENU_TYPE = "MainDish";

    public int calculateDiscount(DayOfWeek visitDayOfWeek, Map<String, Integer> orderHistory) {
        if (isWeekendEvent(visitDayOfWeek)) {
            return calculateWeekendDiscount(orderHistory);
        }
        return NO_DISCOUNT_AMOUNT;
    }

    private boolean isWeekendEvent(DayOfWeek visitDayOfWeek) {
        return visitDayOfWeek.isWeekend();
    }

    private int calculateWeekendDiscount(Map<String, Integer> orderHistory) {
        int dessertQuantity = orderHistory.entrySet().stream()
                .filter(entry -> Menu.valueOf(entry.getKey()).getMenuType().equals(MAIN_MENU_TYPE))
                .mapToInt(Map.Entry::getValue)
                .sum();

        return MAIN_DISH_DISCOUNT * dessertQuantity;
    }
}
