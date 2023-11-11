package christmas.domain;

import java.util.Map;

public class WeekendDiscount {
    private static final int MAIN_DISH_DISCOUNT = 2023;

    public int calculateDiscount(DayOfWeek visitDayOfWeek, Map<String, Integer> orderHistory) {
        if (isWeekendEvent(visitDayOfWeek)) {
            return calculateWeekendDiscount(orderHistory);
        }
        return 0;
    }

    private boolean isWeekendEvent(DayOfWeek visitDayOfWeek) {
        return visitDayOfWeek.isWeekend();
    }

    private int calculateWeekendDiscount(Map<String, Integer> orderHistory) {
        int dessertQuantity = orderHistory.entrySet().stream()
                .filter(entry -> Menu.valueOf(entry.getKey()).getMenuType().equals("MainDish"))
                .mapToInt(Map.Entry::getValue)
                .sum();

        return MAIN_DISH_DISCOUNT * dessertQuantity;
    }
}
