package example.hp.wandroid;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {
        String TAG = getClass().getSimpleName();
        Map test = new ConcurrentHashMap<String, String>();
        test.put("a", "aaaaa");
        test.put("b", "bbbbb");
        test.put("c", "ccccc");
        for (Object entry : test.entrySet()) {
            d(entry.toString());

        }


        assertEquals(4, 2 + 2);
    }

    public void d(String s) {
        System.out.println(s);
    }
}