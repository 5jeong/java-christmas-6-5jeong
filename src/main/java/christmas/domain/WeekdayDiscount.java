package christmas.domain;

import java.util.Map;

public class WeekdayDiscount {

    private static final int DESSERT_DISCOUNT = 2023;

    public int calculateDiscount(DayOfWeek visitDayOfWeek, Map<String, Integer> orderHistory) {
        if (isWeekdayEvent(visitDayOfWeek)) {
            return calculateWeekdayDiscount(orderHistory);
        }
        return 0;
    }

    private boolean isWeekdayEvent(DayOfWeek visitDayOfWeek) {
        return visitDayOfWeek.isWeekday();
    }

    private int calculateWeekdayDiscount(Map<String, Integer> orderHistory) {
        int dessertQuantity = orderHistory.entrySet().stream()
                .filter(entry -> Menu.valueOf(entry.getKey()).getMenuType().equals("Dessert"))
                .mapToInt(Map.Entry::getValue)
                .sum();

        return DESSERT_DISCOUNT * dessertQuantity;
    }

}
