package menu.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DayCategory {
    private final List<Category> dayCategory = new ArrayList<>();

    public DayCategory(CategoryCalculator categoryCalculator) {
        makeDayCategory(categoryCalculator);
    }

    public List<Category> getDayCategory() {
        return dayCategory;
    }

    private void makeDayCategory(CategoryCalculator categoryCalculator) {
        Map<Category, Integer> count = makeEmpty();
        while (dayCategory.size() != 5) {
            Category categoryValue = categoryCalculator.calculate();
            if (count.get(categoryValue) <= 2) {
                dayCategory.add(categoryValue);
                count.put(categoryValue, count.get(categoryValue) + 1);
            }
        }
    }

    private Map<Category, Integer> makeEmpty() {
        return new HashMap<>() {{
            put(Category.Japanese, 0);
            put(Category.Korean, 0);
            put(Category.Chinese, 0);
            put(Category.Asian, 0);
            put(Category.Western, 0);
        }};
    }

}
