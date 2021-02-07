package subway.domain;

public class ErrorMessage {

    private static final String PREFIX = "[ERROR] ";
    private static final String NOT_FUNCTION = "선택할 수 없는 기능입니다";
    private static final String NOT_ENROLLED_STATION = "등록되지 않은 역입니다";
    private static final String SAME_STATION_NAME = "출발역과 도착역이 동일합니다";

    public static String isNotFunction() {
        return PREFIX + NOT_FUNCTION;
    }

    public static String isNotStation() {
        return PREFIX + NOT_ENROLLED_STATION;
    }

    public static String isSameStation() {
        return PREFIX + SAME_STATION_NAME;
    }
}
