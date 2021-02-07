package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;



public class LineRepository {

    static final Line LINE_NUMBER_2 = new Line("2호선");
    static final Line LINE_NUMBER_3 = new Line("3호선");
    static final Line LINE_NUMBER_SHINBUNDANG = new Line("신분당선");

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        addLine(LINE_NUMBER_2);
        addLine(LINE_NUMBER_3);
        addLine(LINE_NUMBER_SHINBUNDANG);
        if (LINE_NUMBER_2.getStations().size() == 0) {
            addStationsOnLine();
        }
        return Collections.unmodifiableList(lines);
    }

    public static void addStationsOnLine() {
        LINE_NUMBER_2.addStation(StationRepository.STATION_KYODAE);
        LINE_NUMBER_2.addStation(StationRepository.STATION_GANGNAM);
        LINE_NUMBER_2.addStation(StationRepository.STATION_YEOKSAM);
        LINE_NUMBER_3.addStation(StationRepository.STATION_KYODAE);
        LINE_NUMBER_3.addStation(StationRepository.STATION_NAMBU_TERMINAL);
        LINE_NUMBER_3.addStation(StationRepository.STATION_YANGJAE);
        LINE_NUMBER_3.addStation(StationRepository.STATION_MAEBONG);
        LINE_NUMBER_SHINBUNDANG.addStation(StationRepository.STATION_GANGNAM);
        LINE_NUMBER_SHINBUNDANG.addStation(StationRepository.STATION_YANGJAE);
        LINE_NUMBER_SHINBUNDANG.addStation(StationRepository.STATION_YANGJAE_FOREST);
    }

    public static void addLine(Line line) {
        for (Line enrolledLine : lines) {
            if (enrolledLine.getName().equals(line.getName())) {
                return;
            }
        }
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

}
