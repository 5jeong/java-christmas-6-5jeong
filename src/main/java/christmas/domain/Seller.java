package christmas.domain;

import christmas.util.ConverterUtil;
import christmas.view.OutputConstants;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Seller {
    private static final int MINIMUM_ORDER_MENU_COUNT = 1;
    private static final int MAXIMUM_ORDER_MENU_COUNT = 20;
    private static final String DRINK_MENU_TYPE = "Drink";
    private static Map<String, Integer> orderHistory;

    public Seller(String orderHistoty) {
        validateMenuAnoCount(orderHistoty);
        this.orderHistory = ConverterUtil.convertStringToMap(orderHistoty);
    }

    public void validateMenuAnoCount(String orderHistoty) {
        validateConvertStringToMap(orderHistoty);
        Map<String, Integer> orderResult = ConverterUtil.convertStringToMap(orderHistoty);
        validateDuplicateMenu(orderHistoty, orderResult);
        validateMenuExists(orderResult);
        validateQuantity(orderResult);
        validateDrinkOnly(orderResult);
    }
    private void validateConvertStringToMap(String orderHistoty){
        try {
            Map<String, Integer> orderResult = ConverterUtil.convertStringToMap(orderHistoty);
        }catch (ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException(OutputConstants.ORDER_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateMenuExists(Map<String, Integer> orderResult) {
        if (orderResult.keySet().stream().anyMatch(orderMenu -> !menuContains(orderMenu))) {
            throw new IllegalArgumentException(OutputConstants.ORDER_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateDuplicateMenu(String orderHistoty, Map<String, Integer> orderMap) {
        List<String> orderHistotys = ConverterUtil.covertStringToList(orderHistoty);
        if (orderHistotys.size() != orderMap.size()) {
            throw new IllegalArgumentException(OutputConstants.ORDER_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateDrinkOnly(Map<String, Integer> orderResult) {
        boolean drinksOnly = orderResult.keySet().stream()
                .map(Menu::valueOf)
                .allMatch(menu -> DRINK_MENU_TYPE.equals(menu.getMenuType()));
        if (drinksOnly) {
            throw new IllegalArgumentException(OutputConstants.ORDER_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateQuantity(Map<String, Integer> orderResult) {
        orderResult.forEach((orderMenu, count) -> {
            if (count < MINIMUM_ORDER_MENU_COUNT || count > MAXIMUM_ORDER_MENU_COUNT) {
                throw new IllegalArgumentException(OutputConstants.ORDER_INPUT_ERROR_MESSAGE);
            }
        });
    }

    private static boolean menuContains(String orderMenu) {
        return Arrays.stream(Menu.values())
                .anyMatch(menu -> menu.name().equals(orderMenu));
    }

    public int totalOrderAmount() {
        return orderHistory.entrySet().stream()
                .mapToInt(entry -> Menu.valueOf(entry.getKey()).getPrice() * entry.getValue())
                .sum();
    }

    public Map<String, Integer> getOrderHistory() {
        return Collections.unmodifiableMap(orderHistory);
    }
}
