package subway.domain;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Scanner;

public class LineManageScreenInput {

    public String chooseOnLineManageScreen(Scanner scanner) throws IllegalArgumentException{
        String lineManageChoice = scanner.next();
        if (lineManageChoice.equals("1")) {
            return lineManageChoice;
        } else if (lineManageChoice.equals("2")) {
            return lineManageChoice;
        } else if (lineManageChoice.equals("3")) {
            return lineManageChoice;
        } else if (lineManageChoice.equals("B")) {
            return lineManageChoice;
        }
        throw new IllegalArgumentException();
    }

    public String enrollLine(Scanner scanner) throws IllegalArgumentException{
        String lineName = scanner.next();
        for (Line line : LineRepository.lines()) {
            if (line.getName().equals(lineName)) {
                throw new IllegalArgumentException();
            }
        }
        return lineName;
    }

    public String deleteLine(Scanner scanner) throws IllegalArgumentException{
        String lineName = scanner.next();
        for (Line line : LineRepository.lines()) {
            if (line.getName().equals(lineName)) {
                return lineName;
            }
        }
        throw new IllegalArgumentException();
    }

    public Station upTrainLine(Scanner scanner) throws IllegalArgumentException{
        String upTrainStation = scanner.next();
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(upTrainStation)) {
                return station;
            }
        }
        throw new IllegalArgumentException();
    }

    public Station downTrainLine(Scanner scanner) throws IllegalArgumentException{
        String upTrainStation = scanner.next();
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(upTrainStation)) {
                return station;
            }
        }
        throw new IllegalArgumentException();
    }
}
