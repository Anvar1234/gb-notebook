package notebook.util;

import java.util.Scanner;

public final class Utils {
    private Utils() {
    }

    public static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
