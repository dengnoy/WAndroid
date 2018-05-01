package example.hp.wandroid.util;

import java.util.ArrayList;
import java.util.List;

public class Mock {
    private static volatile int index = 1;

   synchronized public static List<String> getDatas() {
        List<String> datas = new ArrayList<String>();
        for (int a = 0; a < 30; a++) {
            datas.add("Is't mocked data :hello world !  < " + a + " >");
            index++;
        }
        return datas;
    }
}
