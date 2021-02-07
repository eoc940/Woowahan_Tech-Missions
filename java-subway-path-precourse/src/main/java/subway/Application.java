package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.SubwayPathProgram;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        SubwayPathProgram subwayPathProgram = new SubwayPathProgram();
        subwayPathProgram.run(scanner);
        scanner.close();

    }
}
