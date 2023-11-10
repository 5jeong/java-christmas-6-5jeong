package christmas.util;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConverterUtil {
    public static List<String> covertStringToList(String str) {
        return Arrays.stream(str.split(",")).map(String::trim).collect(Collectors.toList());
    }

    public static Map<String, Integer> convertStringToMap(String str) {
        return Arrays.stream(str.split(","))
                .map(String::trim)
                .map(item -> item.split("-"))
                .collect(Collectors.toMap(
                        parts -> parts[0],    // 음식의 이름
                        parts -> Integer.parseInt(parts[1]),  // 수량
                        (existing, replacement) -> existing + replacement, // 중복 메뉴 합치기
                        LinkedHashMap::new // LinkedHashMap 사용하여 순서 보장
                ));
    }

    public static Integer convertStringToInt(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        String input = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Map<String, Integer> itemMap = convertStringToMap(input);
        System.out.println(itemMap);

    }

}
