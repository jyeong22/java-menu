package menu.domain;

import java.util.*;
import java.util.stream.Collectors;

public class MenuCantEat {
    private final List<String> names;
    private final Map<String, List<String>> cantEatFood = new LinkedHashMap<>();

    public MenuCantEat(String inputNames) {
        this.names = validateCoaches(inputNames);
    }

    public List<String> getNames() {
        return names;
    }

    public Map<String, List<String>> getCantEatFood() {
        return cantEatFood;
    }

    public void add(String name, String cantEatMenu) {
        List<String> cantEatMenus = validateCantEatMenu(cantEatMenu);
        cantEatFood.put(name, cantEatMenus);
    }

    private List<String> validateCantEatMenu(String cantEatMenu) {
        List<String> separateMenus = separate(cantEatMenu);
        validateMenusCount(separateMenus);
        validateMenusInMenuBoard(separateMenus);
        return separateMenus;
    }

    private void validateMenusInMenuBoard(List<String> separateMenus) {
        for(String menu : separateMenus){
            if(!Menu.isInMenuBoard(menu)){
                throw new IllegalArgumentException("[ERROR] 메뉴판 안의 메뉴를 입력해야 합니다.");
            }
        }
    }

    private void validateMenusCount(List<String> separateMenus) {
        if (separateMenus.size() < 0 || separateMenus.size() > 2) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 0개 최대 2개의 못 먹는 메뉴가 있습니다.");
        }
    }

    private List<String> validateCoaches(String inputNames) {
        List<String> names = separate(inputNames);
        validateIsNotEmpty(names);
        validateCoachesCount(names);
        validateNotDuplicated(names);
        validateNameLength(names);
        return names;
    }

    private void validateNotDuplicated(List<String> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 모두 달라야 합니다.");

        }
    }

    private void validateNameLength(List<String> names) {
        boolean checkValue = names.stream().allMatch(name -> name.length() >= 2 && name.length() <= 4);
        if (!checkValue) {
            throw new IllegalArgumentException("[ERROR] 2이상 4이하의 코치 이름을 입력해 주세요.");
        }
    }

    private void validateIsNotEmpty(List<String> names) {
        if (names.size() < 0) {
            throw new IllegalArgumentException("[ERROR] 코치 이름을 입력해 주세요.");
        }
    }


    private void validateCoachesCount(List<String> names) {
        if (names.size() < 2 || names.size() > 5) {
            throw new IllegalArgumentException("[ERROR] 코치의 수는 최소 2명, 최대 5명 입니다.");
        }
    }

    private List<String> separate(String inputNames) {
        String removeBlankNames = inputNames.replace(" ", "");
        String[] splitNames = removeBlankNames.split(",");
        List<String> collect = Arrays.stream(splitNames).collect(Collectors.toList());
        return collect;
    }

}
