package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRecommendResult {
    private final Map<String, List<String>> menuRecommendResult;

    public MenuRecommendResult(DayCategory dayCategory, MenuCantEat menuCantEat) {
        menuRecommendResult = new HashMap<>(){{
            Map<String, List<String>> cantEatFood = menuCantEat.getCantEatFood();
            for(Entry<String, List<String>> value : cantEatFood.entrySet()){
                put(value.getKey(), new ArrayList<>());
            }
        }};
        makeMenuRecommendResult(dayCategory, menuCantEat);
    }

    public Map<String, List<String>> getMenuRecommendResult() {
        return menuRecommendResult;
    }

    private void makeMenuRecommendResult(DayCategory dayCategory, MenuCantEat menuCantEat) {
        List<Category> dayCategoryValues = dayCategory.getDayCategory();
        System.out.println(dayCategoryValues);
        for(Category category : dayCategoryValues){
            Map<String, List<String>> cantEatFood = menuCantEat.getCantEatFood();
            for(Map.Entry<String, List<String>> coachAndCantEatFood : cantEatFood.entrySet()){
                String coachName = coachAndCantEatFood.getKey();
                List<String> canEatFood = coachAndCantEatFood.getValue();
                String menuName = Randoms.shuffle(Menu.getThisMenus(category)).get(0);
                addMenuRecommendResult(menuName, coachName, canEatFood);
            }
        }

    }

    private void addMenuRecommendResult(String menuName, String coachName, List<String> canEatFood) {
        if(!canEatFood.contains(menuName) && !menuRecommendResult.get(coachName).contains(menuName)){
            menuRecommendResult.get(coachName).add(menuName);
        }
    }
}
