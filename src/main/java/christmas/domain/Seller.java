package christmas.domain;

import christmas.util.ConverterUtil;
import java.util.List;
import java.util.Map;

public class Seller {

    private static Map<String, Integer> orderHistory;

    public Seller(String orderHistoty) {
        validateDate(orderHistoty);
        this.orderHistory = ConverterUtil.convertStringToMap(orderHistoty);
    }

    public void validateDate(String orderHistoty) throws IllegalArgumentException {
        try {
            Map<String, Integer> orderResult = ConverterUtil.convertStringToMap(orderHistoty);
            validateDuplicateMenu(orderHistoty, orderResult);
            validateMenuExists(orderResult);
            validateQuantity(orderResult);
            validateDrinkOnly(orderResult);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateMenuExists(Map<String, Integer> orderResult) {
        // 메뉴가 메뉴판에 없는 경우
        for (String orderMenu : orderResult.keySet()) {
            if (!MenuContains(orderMenu)) {
                throw new IllegalArgumentException("메뉴판에업슴");
            }
        }
    }

    private void validateDuplicateMenu(String orderHistoty, Map<String, Integer> orderMap) {
        List<String> orderHistotys = ConverterUtil.covertStringToList(orderHistoty);
        if (orderHistotys.size() != orderMap.size()) {
            throw new IllegalArgumentException("중복");
        }
    }

    private void validateDrinkOnly(Map<String, Integer> orderResult) {
        // 음료만 주문했을 경우
        for (String orderMenu : orderResult.keySet()) {
            Menu menu = Menu.valueOf(orderMenu);
            if (menu.getMenuType() != "Drink") {
                return;
            }
        }
        throw new IllegalArgumentException("음료만 입력함");
    }

    private void validateQuantity(Map<String, Integer> orderResult) {
        // 메뉴의 개수가 1 이상 20 이하가 아닌 경우
        for (String orderMenu : orderResult.keySet()) {
            if (orderResult.get(orderMenu) < 1 || orderResult.get(orderMenu) > 20) {
                throw new IllegalArgumentException("1이상 20이하개만 주문가능");
            }
        }
    }

    private static boolean MenuContains(String orderMenu) {
        for (Menu menu : Menu.values()) {
            if (menu.name().equals(orderMenu)) {
                return true;
            }
        }
        return false;
    }
    public int totalOrderAmount(){
        int totalOrderAmount=0;
        for(String orderMenu : orderHistory.keySet()){
            totalOrderAmount += Menu.valueOf(orderMenu).getPrice() * orderHistory.get(orderMenu);
        }
        return totalOrderAmount;
    }

    public boolean isServiceMenu(){
        return totalOrderAmount() >= 120000;
    }


    public  Map<String, Integer> getOrderHistory() {
        return orderHistory;
    }
}
