package christmas.view;

import java.util.regex.Pattern;

public class InputViewValidator {
    private static final String MENU_AND_COUNT_REGEX = "^([^\\d-]+-\\d+)(,\\s*[^\\d-]+-\\d+)*\\s*$";

    public void validateMenuFormat(String orderMenuAndCount){
        if(!Pattern.compile(MENU_AND_COUNT_REGEX).matcher(orderMenuAndCount).matches()){
            throw new IllegalArgumentException(OutputConstants.ORDER_INPUT_ERROR_MESSAGE);
        }
    }
}
