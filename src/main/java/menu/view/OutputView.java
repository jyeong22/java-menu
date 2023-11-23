package menu.view;

public class OutputView {
    public static void printStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    public static void printResult(String s) {
        System.out.println("\n메뉴 추천 결과입니다.");
        System.out.println(s);
    }

    public static void printEnd() {
        System.out.println("추천을 완료했습니다.");
    }
}
