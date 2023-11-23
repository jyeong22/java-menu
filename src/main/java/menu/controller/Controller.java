package menu.controller;

import menu.domain.*;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.Map;

public class Controller {

    public void proceed(){
        OutputView.printStart();
        MenuCantEat menuCantEat = new MenuCantEat(InputView.inputCoachesName());
        List<String> names = menuCantEat.getNames();
        for(String name : names){
            System.out.println();
            String cantEatMenu = InputView.inputCantEatMenu(name);
            menuCantEat.add(name, cantEatMenu);
        }
        DayCategory dayCategory = new DayCategory(new CategoryCalculator());
        MenuRecommendResult menuRecommendResult = new MenuRecommendResult(dayCategory, menuCantEat);
        Map<String, List<String>> menuRecommendResultValue = menuRecommendResult.getMenuRecommendResult();
        String s = ResultPrintMaker.resultString(dayCategory.getDayCategory(), menuRecommendResultValue);
        OutputView.printResult(s);
        OutputView.printEnd();


    }
}

// 3시간 반..? 남은 1시간 반동안 테스트 코드 & 리팩토링
// 리팩토링에 시간 많이 들이지 않도록 자바 컨벤션 지키면서