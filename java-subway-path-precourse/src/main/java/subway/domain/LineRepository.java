package subway.domain;



import java.lang.reflect.Array;
import java.util.*;

public class LineRepository extends StationRepository{

    private static final Line lineTwo = new Line("2호선");
    private static final Line lineThree = new Line("3호선");
    private static final Line lineShinBunDang = new Line("신분당선");


    private static final List<Line> lines = Arrays.asList(lineTwo, lineThree, lineShinBunDang);

    public static List<Line> lines() {
        lineTwo.addStation(kyoDae);
        lineTwo.addStation(gangNam);
        lineTwo.addStation(yokSam);
        lineThree.addStation(kyoDae);
        lineThree.addStation(namBuTerminal);
        lineThree.addStation(yangJae);
        lineThree.addStation(yangJaeForest);
        lineShinBunDang.addStation(gangNam);
        lineShinBunDang.addStation(yangJae);
        lineShinBunDang.addStation(yangJaeForest);
        return Collections.unmodifiableList(lines);
    }

}
