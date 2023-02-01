

import java.io.File;
import java.io.IOException;
import java.awt.Desktop;

public class LtWinDriver {
    public static void start() {
        try {
            Desktop d = Desktop.getDesktop();
            d.open(new File("C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe"));
            //d.open(new File("drivers/WinAppDriver.exe"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void stopExcel() {
        try {
            ProcessBuilder killexcel =new ProcessBuilder("taskkill ","/f","/IM","Excel.exe");
            killexcel.start();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
