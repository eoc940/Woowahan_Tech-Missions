package subway;

import subway.domain.MainScreenInput;

import java.util.Scanner;

public class MainScreenProgram {

    static final String MAIN_SCREEN = "## 메인 화면";
    static final String STATION_MANAGE = "1. 역 관리";
    static final String LINE_MANAGE = "2. 노선 관리";
    static final String SECTION_MANAGE = "3. 구간 관리";
    static final String PRINT_SUBWAY = "4. 지하철 노선도 출력";
    static final String QUIT = "Q. 종료";
    static final String SELECT_FUNCTION = "## 원하는 기능을 선택하세요";


    private final MainScreenInput mainScreenInput = new MainScreenInput();

    public String printMain(Scanner scanner) {
        System.out.println(MAIN_SCREEN);
        System.out.println(STATION_MANAGE);
        System.out.println(LINE_MANAGE);
        System.out.println(SECTION_MANAGE);
        System.out.println(PRINT_SUBWAY);
        System.out.println(QUIT);
        System.out.println(SELECT_FUNCTION);
        return mainScreenInput.chooseOnMainScreen(scanner);
    }






}
