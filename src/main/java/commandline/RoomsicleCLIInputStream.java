package commandline;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class RoomsicleCLIInputStream {

    public int getNumberResponse(InputStream in, PrintStream out) {
        Scanner keyboard = new Scanner(in);
        int input = keyboard.nextInt();
        return input;
    }

    public static int testUserInput(InputStream in,PrintStream out) {
        Scanner keyboard = new Scanner(in);
        out.println("Give a number between 1 and 10");
        int input = keyboard.nextInt();

        while (input < 1 || input > 10) {
            out.println("Wrong number, try again.");
            input = keyboard.nextInt();
        }

        return input;
    }

}
