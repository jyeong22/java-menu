package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String inputCantEatMenuMessage = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String inputCoachesNameMessage = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public static String inputCoachesName(){
        System.out.println(inputCoachesNameMessage);
        return Console.readLine();
    }

    public static String inputCantEatMenu(String coachName){
        System.out.println(String.format(inputCantEatMenuMessage, coachName));
        return Console.readLine();
    }
}
