package subway.domain;

import java.util.Scanner;

public class StationManageScreenInput {

    Scanner scanner;

    public String chooseOnStationManageScreen(Scanner scanner) throws IllegalArgumentException{
        String stationManageChoice = scanner.next();
        if (stationManageChoice.equals("1")) {
            return stationManageChoice;
        } else if (stationManageChoice.equals("2")) {
            return stationManageChoice;
        } else if (stationManageChoice.equals("3")) {
            return stationManageChoice;
        } else if (stationManageChoice.equals("B")) {
            return stationManageChoice;
        }
        throw new IllegalArgumentException();
    }

    public String enrollStation(Scanner scanner) throws IllegalArgumentException{
        String stationName = scanner.next();
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(stationName)) {
                throw new IllegalArgumentException();
            }
        }
        return stationName;
    }

    public String deleteStation(Scanner scanner) throws IllegalArgumentException{
        String stationName = scanner.next();
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(stationName)) {
                return stationName;
            }
        }
        throw new IllegalArgumentException();
    }

    public void a() {
        enrollStation(scanner);
    }
}
