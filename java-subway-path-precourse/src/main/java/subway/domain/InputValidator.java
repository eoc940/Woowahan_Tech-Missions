package subway.domain;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    private static final List<String> mainFunctionList = Arrays.asList("1", "Q");
    private static final List<String> pathFunctionList = Arrays.asList("1", "2", "B");

    public static String checkMainFunction(String mainFunction) {
        if (mainFunctionList.contains(mainFunction)) {
            return mainFunction;
        }
        throw new IllegalArgumentException(ErrorMessage.isNotFunction());
    }

    public static String checkPathFunction(String pathFunction) {
        if (pathFunctionList.contains(pathFunction)) {
            return pathFunction;
        }
        throw new IllegalArgumentException(ErrorMessage.isNotFunction());
    }

    public static Station checkStation(String stationName) {
        Station searchedStation = StationRepository.stations()
                .stream()
                .filter(station -> station.getName().equals(stationName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.isNotStation()));
        return searchedStation;
    }

    public static void checkSameStation(Station startStation, Station endStation) {
        if (startStation.equals(endStation)) {
            throw new IllegalArgumentException(ErrorMessage.isSameStation());
        }
    }


}
