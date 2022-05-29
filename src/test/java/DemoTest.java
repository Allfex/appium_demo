import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DemoTest {

    @Test
    public void test01(){
       // System.out.println(System.getProperty("user.dir"));

        try {
//            Runtime.getRuntime().exec("cmd.exe /c start");
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("adb devices");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


        public static void main(String[] args) throws IOException {
            run();
        }

        public static void run() throws IOException {
            Process process = Runtime.getRuntime().exec("cmd /c adb shell input adb devices");

            //Process process = Runtime.getRuntime().exec("ipconfig");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GB2312"));
            String line;
            StringBuilder b = new StringBuilder();
            while((line = bufferedReader.readLine()) != null) {
                b.append(line).append("\n");
            }
            System.out.println(b);
        }


}
