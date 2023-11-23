package menu.domain;

import menu.domain.Category;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultPrintMaker {
    private static final String separator = " | ";
    private static final String openBrace = "[ ";
    private static final String closeBrace = " ]";
    private static final String enter = "\n";

    public static String resultString(List<Category> dayCategory, Map<String, List<String>> menuRecommendResultValue) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n");
        List<String> collect = dayCategory.stream().map(Category::getName).collect(Collectors.toList());
        String categoryResult = String.join(separator, collect);
        stringBuilder.append(openBrace + "카테고리" + separator + categoryResult + closeBrace + enter);
        for (Map.Entry<String, List<String>> value : menuRecommendResultValue.entrySet()) {
            stringBuilder.append(openBrace + value.getKey() + separator);
            stringBuilder.append(String.join(separator, value.getValue()));
            stringBuilder.append(closeBrace + enter);
        }
        return stringBuilder.toString();
    }
}
