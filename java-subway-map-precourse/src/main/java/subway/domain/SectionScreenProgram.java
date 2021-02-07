package subway.domain;

import java.util.Scanner;

public class SectionScreenProgram {

    static final String SECTION_MANAGE_SCREEN = "## 구간 관리 화면";
    static final String SECTION_ENROLL = "1. 구간 등록";
    static final String SECTION_DELETE = "2. 구간 삭제";
    static final String GO_BACK = "B. 돌아가기";
    static final String SELECT_FUNCTION = "## 원하는 기능을 선택하세요.";
    static final String INPUT_STATION_NAME = "## 역이름을 입력하세요.";
    static final String INPUT_ORDER = "## 순서를 입력하세요.";
    static final String INPUT_LINE_NAME = "## 노선을 입력하세요.";
    static final String INFO = "[INFO] ";
    static final String SECTION_ENROLLED = "구간이 등록되었습니다";
    static final String INPUT_DELETE_LINE_NAME = "## 삭제할 구간의 노선을 입력하세요.";
    static final String INPUT_DELETE_STATION_NAME = "## 삭제할 구간의 역을 입력하세요.";
    static final String SECTION_DELETED = "구간이 삭제되었습니다.";

    private SectionManageScreenInput sectionManageScreenInput = new SectionManageScreenInput();

    private boolean flag = true;

    public String printSectionManage(Scanner scanner) {
        System.out.println(SECTION_MANAGE_SCREEN);
        System.out.println(SECTION_ENROLL);
        System.out.println(SECTION_DELETE);
        System.out.println(GO_BACK);
        System.out.println(SELECT_FUNCTION);
        return sectionManageScreenInput.chooseOnSectionManageScreen(scanner);
    }

    public Line printLineForEnrollSection(Scanner scanner) {
        System.out.println(INPUT_LINE_NAME);
        return sectionManageScreenInput.inputLine(scanner);
    }

    public Station printStationForEnrollSection(Scanner scanner) {
        System.out.println(INPUT_STATION_NAME);
        return sectionManageScreenInput.enrollSectionStation(scanner);
    }

    public String printOrderForEnrollSection(Scanner scanner) {
        System.out.println(INPUT_ORDER);
        String order = sectionManageScreenInput.inputStationOrder(scanner);
        System.out.println(INFO + SECTION_ENROLLED);
        return order;
    }

    public Line printLineForDeleteSection(Scanner scanner) {
        System.out.println(INPUT_DELETE_LINE_NAME);
        return sectionManageScreenInput.inputLine(scanner);
    }

    public Station printStationForDeleteSection(Scanner scanner) {
        System.out.println(INPUT_DELETE_STATION_NAME);
        Station station = sectionManageScreenInput.deleteSectionStation(scanner);
        System.out.println(INFO + SECTION_DELETED);
        return station;
    }

    public void processEnrollSection(String sectionManage, Scanner scanner) {
        try {
            if (sectionManage.equals("1")) {
                Line line = printLineForEnrollSection(scanner);
                Station station = printStationForEnrollSection(scanner);
                String order = printOrderForEnrollSection(scanner);
                line.addStationOrdering(station, order);
            }
        } catch (IllegalArgumentException illegalArgumentException) {

        }
    }

    public void processDeleteSection(String sectionManage, Scanner scanner) {
        try {
            if (sectionManage.equals("2")) {
                Line line = printLineForDeleteSection(scanner);
                Station station = printStationForDeleteSection(scanner);
                line.removeStationOrdering(station);
            }
        } catch (IllegalArgumentException illegalArgumentException) {

        }
    }

    public void processGoBack(String lineManage) {
        if (lineManage.equals("B")) {
            this.flag = false;
        }
    }

    public void printSectionScreenProgram(Scanner scanner) {
        while (flag) {
            try {
                String sectionManage = printSectionManage(scanner);
                processEnrollSection(sectionManage, scanner);
                processDeleteSection(sectionManage, scanner);
                processGoBack(sectionManage);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("올바르게 입력해라");
            }
        }
        this.flag = true;
    }
}
