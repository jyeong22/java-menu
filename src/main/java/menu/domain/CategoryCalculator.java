package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;

public class CategoryCalculator {
    public static final int Japanese_Value = 1;
    public static final int Korean_Value = 2;
    public static final int Chinese_Value = 3;
    public static final int Asian_Value = 4;
    public static final int Western_Value = 5;

    public static Category calculate() {
        int i = Randoms.pickNumberInRange(1, 5);
        if (i == Japanese_Value){
            return Category.Japanese;
        }
        if (i == Korean_Value){
            return Category.Korean;
        }
        if (i == Chinese_Value){
            return Category.Chinese;
        }
        if (i == Asian_Value){
            return Category.Asian;
        }
        if (i == Western_Value) {
            return Category.Western;
        }
        return null;
    }
}
