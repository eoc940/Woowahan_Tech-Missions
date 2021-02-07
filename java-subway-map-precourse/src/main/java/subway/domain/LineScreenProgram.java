package subway.domain;


import java.util.Scanner;

public class LineScreenProgram {

    static final String LINE_MANAGE_SCREEN = "## 노선 관리 화면";
    static final String LINE_ENROLL = "1. 노선 등록";
    static final String LINE_DELETE = "2. 노선 삭제";
    static final String LINE_INQUIRY = "3. 노선 조회";
    static final String GO_BACK = "B. 돌아가기";
    static final String SELECT_FUNCTION = "## 원하는 기능을 선택하세요.";
    static final String INPUT_UP_TRAIN_TERMINAL = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    static final String INPUT_DOWN_TRAIN_TERMINAL = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    static final String INPUT_ENROLL_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";
    static final String INFO = "[INFO] ";
    static final String LINE_ENROLLED = "지하철 노선이 등록되었습니다";
    static final String INPUT_DELETE_LINE_NAME = "## 삭제할 노선 이름을 입력하세요.";
    static final String LINE_DELETED = "지하철 노선이 삭제되었습니다.";
    static final String LINE_CATEGORY = "노선 목록";

    private LineManageScreenInput lineManageScreenInput = new LineManageScreenInput();

    private boolean flag = true;

    public String printLineManage(Scanner scanner) {
        System.out.println(LINE_MANAGE_SCREEN);
        System.out.println(LINE_ENROLL);
        System.out.println(LINE_DELETE);
        System.out.println(LINE_INQUIRY);
        System.out.println(GO_BACK);
        System.out.println(SELECT_FUNCTION);
        return lineManageScreenInput.chooseOnLineManageScreen(scanner);
    }

    public String printEnrollLine(Scanner scanner) {
        System.out.println(INPUT_ENROLL_LINE_NAME);
        String lineName = lineManageScreenInput.enrollLine(scanner);
        System.out.println(INFO + LINE_ENROLLED);
        return lineName;
    }


    public Station printUpTrain(Scanner scanner) {
        System.out.println(INPUT_UP_TRAIN_TERMINAL);
        return lineManageScreenInput.upTrainLine(scanner);
    }

    public Station printDownTrain(Scanner scanner) {
        System.out.println(INPUT_DOWN_TRAIN_TERMINAL);
        Station downTrain = lineManageScreenInput.downTrainLine(scanner);
        System.out.println(INFO + LINE_ENROLLED);
        return downTrain;
    }

    public String printDeleteLine(Scanner scanner) {
        System.out.println(INPUT_DELETE_LINE_NAME);
        String lineName = lineManageScreenInput.deleteLine(scanner);
        System.out.println(INFO + LINE_DELETED);
        return lineName;
    }

    public void printInquireLine() {
        System.out.println(INFO + LINE_CATEGORY);
        for (Line line : LineRepository.lines()) {
            System.out.println(INFO + line.getName());
        }
        System.out.println();
    }

    public void processEnrollLine(String lineManage, Scanner scanner) {
        try {
            if (lineManage.equals("1")) {
                Line line = new Line(printEnrollLine(scanner));
                line.addStation(printUpTrain(scanner));
                line.addStation(printDownTrain(scanner));
                LineRepository.addLine(line);
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("이미 등록된 노선입니다");
        }
    }

    public void processDeleteLine(String lineManage, Scanner scanner) {
        try {
            if (lineManage.equals("2")) {
                String delLine = printDeleteLine(scanner);
                LineRepository.deleteLineByName(delLine);
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("그런 노선은 없습니다");
        }
    }

    public void processInquireLine(String lineManage) {
        if (lineManage.equals("3")) {
            printInquireLine();
        }
    }

    public void processGoBack(String lineManage) {
        if (lineManage.equals("B")) {
            this.flag = false;
        }
    }
    public void printLineScreenProgram(Scanner scanner) {
        while (flag) {
           try {
               String lineManage = printLineManage(scanner);
               processEnrollLine(lineManage, scanner);
               processDeleteLine(lineManage, scanner);
               processInquireLine(lineManage);
               processGoBack(lineManage);
           } catch (IllegalArgumentException illegalArgumentException) {
               System.out.println("올바르게 입력하세요");
           }
        }
        this.flag = true;
    }




}
