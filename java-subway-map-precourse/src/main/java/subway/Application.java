package subway;

import subway.domain.*;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        Program program = new Program();
        while (program.getFlag()) {
            program.run(scanner);
        }
        scanner.close();




    }
}
