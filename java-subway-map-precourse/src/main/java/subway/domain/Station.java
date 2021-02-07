package subway.domain;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public boolean checkEnrolled(Station station) {
        for (Line line : LineRepository.lines()) {
            if (line.getStations().contains(station)) {
                return true;
            }
        }
        return false;
    }
}
