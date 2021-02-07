package subway.domain;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

import java.util.Scanner;

public class SectionManageScreenInput {

    public String chooseOnSectionManageScreen(Scanner scanner) throws IllegalArgumentException{
        String sectionManageChoice = scanner.next();
        if (sectionManageChoice.equals("1")) {
            return sectionManageChoice;
        } else if (sectionManageChoice.equals("2")) {
            return sectionManageChoice;
        } else if (sectionManageChoice.equals("B")) {
            return sectionManageChoice;
        }
        throw new IllegalArgumentException();
    }

    public Line inputLine(Scanner scanner) throws IllegalArgumentException{
        String lineName = scanner.next();
        for (Line line : LineRepository.lines()) {
            if (line.getName().equals(lineName)) {
                return line;
            }
        }
        throw new IllegalArgumentException();
    }

    public Station enrollSectionStation(Scanner scanner) throws IllegalArgumentException{
        String stationName = scanner.next();
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(stationName)) {
                return station;
            }
        }
        throw new IllegalArgumentException();
    }

    //나중에 손봐야함
    public String inputStationOrder(Scanner scanner) {
        String stationOrder = scanner.next();
        return stationOrder;
    }

    public Station deleteSectionStation(Scanner scanner) throws IllegalArgumentException{
        String stationName = scanner.next();
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(stationName)) {
                return station;
            }
        }
        throw new IllegalArgumentException();
    }

}
