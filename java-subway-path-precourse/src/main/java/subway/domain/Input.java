package subway.domain;

import java.util.Scanner;

public class Input {

    public static String inputMainFunction(Scanner scanner) {
        String mainFunction = scanner.next();
        InputValidator.checkMainFunction(mainFunction);
        return mainFunction;
    }

    public static String inputPathFunction(Scanner scanner) {
        String pathFunction = scanner.next();
        InputValidator.checkPathFunction(pathFunction);
        return pathFunction;
    }

    public static Station inputStationName(Scanner scanner) {
        String stationName = scanner.next();
        return InputValidator.checkStation(stationName);
    }

}
