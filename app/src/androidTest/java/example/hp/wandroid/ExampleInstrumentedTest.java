package example.hp.wandroid;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        Map test = new ConcurrentHashMap<String, String>();
        test.put("a", "aaaaa");
        test.put("b", "bbbbb");
        test.put("c", "ccccc");
        for (Object entry : test.entrySet()) {
            d(entry.toString());

        }
        assertEquals("example.hp.wandroid", appContext.getPackageName());
    }
    void d(String s){
        System.out.println(s);
    }
}
