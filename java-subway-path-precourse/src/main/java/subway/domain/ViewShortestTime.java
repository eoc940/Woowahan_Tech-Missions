package subway.domain;

import org.jgrapht.Graph;

import java.util.List;
import java.util.Scanner;

public class ViewShortestTime extends ViewShortestDistance {

    public void printTimeResult(Station startStation, Station endStation) {
        Graph graphTime = StationRepository.getShortestTimePath();
        List<Station> pathList = controller.getTotalPath(graphTime, startStation, endStation);
        System.out.println(RESULT);
        System.out.println(INFO + LINE);
        Integer totalTime = controller.getTotalWeight(graphTime, startStation, endStation);
        Graph graphDistance = StationRepository.getShortestDistancePath();
        Integer totalDistance = controller.getOtherWeight(graphDistance, pathList);
        System.out.printf(INFO + TOTAL_DISTANCE + "\n", totalDistance);
        System.out.printf(INFO + TOTAL_TIME + "\n", totalTime);
        System.out.println(INFO + LINE);
        for (Station station : pathList) {
            System.out.println(INFO + station.getName());
        }
    }

    public void executeShortTime(Scanner scanner) {
        Station startStation = printStartStation(scanner);
        Station endStation = printEndStation(scanner);
        InputValidator.checkSameStation(startStation, endStation);
        printTimeResult(startStation, endStation);

    }

    public void selectPathFunction(Scanner scanner, String function) {
        if (function.equals(FUNCTION_DISTANCE)) {
            executeShortDistance(scanner);
        }
        if (function.equals(FUNCTION_TIME)) {
            executeShortTime(scanner);
        }
        if (function.equals(FUNCTION_BACK)) {
            this.goBack = true;
        }
    }

    public void executePathFunction(Scanner scanner) {
        this.goBack = false;
        while (!goBack) {
            try {
                printPathScreen();
                String function = printPathFunction(scanner);
                selectPathFunction(scanner, function);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }

}


