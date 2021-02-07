package subway.domain;

import java.util.Scanner;

public class StationScreenProgram {

    static final String STATION_MANAGE_SCREEN = "## 역 관리 화면";
    static final String STATION_ENROLL = "1. 역 등록";
    static final String STATION_DELETE = "2. 역 삭제";
    static final String STATION_INQUIRY = "3. 역 조회";
    static final String GO_BACK = "B. 돌아가기";
    static final String SELECT_FUNCTION = "## 원하는 기능을 선택하세요.";
    static final String INPUT_ENROLL_STATION_NAME = "## 등록할 역 이름을 입력하세요.";
    static final String INFO = "[INFO] ";
    static final String STATION_ENROLLED = "지하철 역이 등록되었습니다";
    static final String INPUT_DELETE_STATION_NAME = "## 삭제할 역 이름을 입력하세요.";
    static final String STATION_DELETED = "지하철 역이 삭제되었습니다.";
    static final String STATION_CATEGORY = "## 역 목록";

    private StationManageScreenInput stationManageScreenInput = new StationManageScreenInput();
    private boolean flag = true;

    public String printStationManage(Scanner scanner) {
        System.out.println(STATION_MANAGE_SCREEN);
        System.out.println(STATION_ENROLL);
        System.out.println(STATION_DELETE);
        System.out.println(STATION_INQUIRY);
        System.out.println(GO_BACK);
        System.out.println(SELECT_FUNCTION);
        return stationManageScreenInput.chooseOnStationManageScreen(scanner);
    }

    public String printEnrollStation(Scanner scanner) {
        System.out.println(INPUT_ENROLL_STATION_NAME);
        String stationName = stationManageScreenInput.enrollStation(scanner);
        System.out.println(INFO + STATION_ENROLLED);
        return stationName;
    }

    public String printDeleteStation(Scanner scanner) {
        System.out.println(INPUT_DELETE_STATION_NAME);
        String stationName = stationManageScreenInput.deleteStation(scanner);
        System.out.println(INFO + STATION_DELETED);
        return stationName;
    }

    public void printInquireStation() {
        System.out.println(STATION_CATEGORY);
        for (Station station : StationRepository.stations()) {
            System.out.println(INFO + station.getName());
        }
        System.out.println();
    }


    public void processEnrollStation(String stationManage, Scanner scanner) {
        try {
            if (stationManage.equals("1")) {
                Station station = new Station(printEnrollStation(scanner));
                StationRepository.addStation(station);
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("이미 등록된 역입니다");
        }
    }

    public void processDeleteStation(String stationManage,Scanner scanner) {
        try {
            if (stationManage.equals("2")) {
                String delStation = printDeleteStation(scanner);
                StationRepository.deleteStation(delStation);
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("그런 이름 없다");
        }
    }

    public void processInquireStation(String stationManage) {
        if (stationManage.equals("3")) {
            printInquireStation();
        }
    }

    public void processGoBack(String stationManage) {
        if (stationManage.equals("B")) {
            this.flag = false;
        }
    }

    public void printStationScreenProgram(Scanner scanner) {
        while (flag) {
            try {
                String stationManage = printStationManage(scanner);
                processEnrollStation(stationManage, scanner);
                processDeleteStation(stationManage, scanner);
                processInquireStation(stationManage);
                processGoBack(stationManage);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("올바른걸 입력하세요");
            }
        }
        this.flag = true;

    }


}
