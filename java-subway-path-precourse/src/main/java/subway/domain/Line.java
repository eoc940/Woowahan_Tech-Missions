package subway.domain;

import java.util.ArrayList;
import java.util.List;


public class Line {
    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public void addStation(Station station) {
        if (getStations().contains(station)) {
            return;
        }
        if (StationRepository.stations().contains(station)) {
            stations.add(station);
        }
    }
    public List<Station> getStations() {
        return stations;
    }


}
