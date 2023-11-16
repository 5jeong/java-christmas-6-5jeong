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
                        parts -> parts[0],
                        parts -> convertStringToInt(parts[1]),
                        (existing, replacement) -> existing + replacement,
                        LinkedHashMap::new
                ));
    }

    public static Integer convertStringToInt(String str) {
        return Integer.parseInt(str);
    }
}
