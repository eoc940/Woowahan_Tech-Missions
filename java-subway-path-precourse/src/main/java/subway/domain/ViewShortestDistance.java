package subway.domain;

import org.jgrapht.Graph;

import java.util.List;
import java.util.Scanner;

public class ViewShortestDistance {

    static final String PATH_CRITERIA = "## 경로 기준";
    static final String SHORTEST_DISTANCE = "1. 최단 거리";
    static final String SHORTEST_TIME = "2. 최소 시간";
    static final String BACK = "B. 돌아가기";
    static final String START_STATION = "\n## 출발역을 입력하세요";
    static final String END_STATION = "\n## 도착역을 입력하세요";
    static final String FUNCTION_DISTANCE = "1";
    static final String FUNCTION_TIME = "2";
    static final String FUNCTION_BACK = "B";
    static final String RESULT = "\n## 조회 결과";
    static final String INFO = "[INFO] ";
    static final String LINE = "---";
    static final String TOTAL_DISTANCE = "총 거리 : %dkm";
    static final String TOTAL_TIME = "총 소요 시간 : %d분";
    static final String SELECT_FUNCTION = "## 원하는 기능을 선택하세요";

    public boolean goBack = false;
    PathController controller = new PathController();

    public void printPathScreen() {
        System.out.println();
        System.out.println(PATH_CRITERIA);
        System.out.println(SHORTEST_DISTANCE);
        System.out.println(SHORTEST_TIME);
        System.out.println(BACK);
        System.out.println();
    }

    public String printPathFunction(Scanner scanner) {
        System.out.println(SELECT_FUNCTION);
        return Input.inputPathFunction(scanner);
    }

    public Station printStartStation(Scanner scanner) {
        System.out.println(START_STATION);
        return Input.inputStationName(scanner);

    }

    public Station printEndStation(Scanner scanner) {
        System.out.println(END_STATION);
        return Input.inputStationName(scanner);

    }

    public void printDistanceResult(Station startStation, Station endStation) {
        Graph graphDistance = StationRepository.getShortestDistancePath();
        List<Station> pathList = controller.getTotalPath(graphDistance, startStation, endStation);
        System.out.println(RESULT);
        System.out.println(INFO + LINE);
        Integer totalDistance = controller.getTotalWeight(graphDistance, startStation, endStation);
        Graph graphTime = StationRepository.getShortestTimePath();
        Integer totalTime = controller.getOtherWeight(graphTime, pathList);
        System.out.printf(INFO + TOTAL_DISTANCE+"\n", totalDistance);
        System.out.printf(INFO + TOTAL_TIME+"\n", totalTime);
        System.out.println(INFO + LINE);
        for (Station station : pathList) {
            System.out.println(INFO + station.getName());
        }
    }

    public void executeShortDistance(Scanner scanner) {
        Station startStation = printStartStation(scanner);
        Station endStation = printEndStation(scanner);
        InputValidator.checkSameStation(startStation, endStation);
        printDistanceResult(startStation, endStation);
    }


}
