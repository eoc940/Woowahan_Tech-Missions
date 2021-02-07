package subway.domain;

import java.util.Scanner;

public class MainScreenInput {

    public String chooseOnMainScreen(Scanner scanner) throws IllegalArgumentException{
        String mainChoice = scanner.next();
        if (mainChoice.equals("1")) {
            return mainChoice;
        } else if (mainChoice.equals("2")) {
            return mainChoice;
        } else if (mainChoice.equals("3")) {
            return mainChoice;
        } else if (mainChoice.equals("4")) {
            return mainChoice;
        } else if (mainChoice.equals("Q")) {
            return mainChoice;
        }
        throw new IllegalArgumentException();
    }
}
