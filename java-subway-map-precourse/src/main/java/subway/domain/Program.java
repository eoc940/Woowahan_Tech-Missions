package subway.domain;

import subway.MainScreenProgram;

import java.util.Scanner;

public class Program {

    private final MainScreenProgram mainScreenProgram = new MainScreenProgram();
    private final StationScreenProgram stationScreenProgram = new StationScreenProgram();
    private final LineScreenProgram lineScreenProgram = new LineScreenProgram();
    private final SectionScreenProgram sectionScreenProgram = new SectionScreenProgram();
    private final subwayRouteMapProgram subwayRouteMapProgram = new subwayRouteMapProgram();

    private boolean flag = true;

    public void setFlag() {
        this.flag = !flag;
    }

    public boolean getFlag() {
        return flag;
    }

    public void run(Scanner scanner) {
        try {
            String mainScreen = mainScreenProgram.printMain(scanner);
            if (mainScreen.equals("Q")) {
                setFlag();
            } else if (mainScreen.equals("1")) {
                stationScreenProgram.printStationScreenProgram(scanner);
            } else if (mainScreen.equals("2")) {
                lineScreenProgram.printLineScreenProgram(scanner);
            } else if (mainScreen.equals("3")) {
                sectionScreenProgram.printSectionScreenProgram(scanner);
            } else if (mainScreen.equals("4")) {
                subwayRouteMapProgram.printLineAndStation();
            }
        } catch (IllegalArgumentException illegalArgumentException) {

        }



    }
}
