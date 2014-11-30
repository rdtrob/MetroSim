/**
 * Created by robert on 11/24/14.
 */

import java.util.Scanner;

public class InputDevice {
    public Scanner scan;

    public InputDevice() {
        scan = new Scanner(System.in);
    }

    public String getKeyboardInput() {
        return scan.nextLine();
    }
}
