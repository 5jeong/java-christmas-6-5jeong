package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.ConverterUtil;

public class InputView {
    private static final String START_EVENT_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EXPECTED_VISIT_DATE_INPUT_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String ORDER_MENU_AND_COUNT_INPUT_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public void startEventMessageInput(){
        System.out.println(START_EVENT_MESSAGE);
    }
    public String expectedVisitDateInput() {
        System.out.println(EXPECTED_VISIT_DATE_INPUT_MESSAGE);
        String expectedVisitDate = Console.readLine();
        return expectedVisitDate;
    }

    public String orderMenuAndCountInput(){
        System.out.println(ORDER_MENU_AND_COUNT_INPUT_MESSAGE);
        String orderMenuAndCount = Console.readLine();
        return orderMenuAndCount;
    }

}
