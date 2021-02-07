package subway.domain;

import java.util.Scanner;

public class ViewMain {

    static final String MAIN_SCREEN = "\n## 메인 화면";
    private static final String FIND_PATH = "1. 경로 조회";
    private static final String QUIT = "Q. 종료";
    static final String SELECT_FUNCTION = "## 원하는 기능을 선택하세요";
    private static final String FUNCTION_FIND_PATH = "1";
    private static final String FUNCTION_QUIT = "Q";
    private boolean quit = false;

    public void printMainScreen() {
        System.out.println(MAIN_SCREEN);
        System.out.println(FIND_PATH);
        System.out.println(QUIT);
        System.out.println();
    }

    public String printMainFunction(Scanner scanner) {
        System.out.println(SELECT_FUNCTION);
        return Input.inputMainFunction(scanner);
    }


    public void executePath(Scanner scanner, String function) {
        ViewShortestTime viewShortestTime = new ViewShortestTime();
        if (function.equals(FUNCTION_FIND_PATH)) {
            viewShortestTime.executePathFunction(scanner);
        }
    }

    public void quitProgram(String function) {
        if (function.equals(FUNCTION_QUIT)) {
            this.quit = true;
        }
    }

    public void executeMain(Scanner scanner) {
        this.quit = false;
        while (!quit) {
            try {
                printMainScreen();
                String function = printMainFunction(scanner);
                quitProgram(function);
                executePath(scanner, function);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }



}
