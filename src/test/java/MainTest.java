package test.java;

import org.junit.Before;
import org.junit.Test;
import main.java.Main;
import static org.junit.Assert.*;

public class MainTest {
     Main main;

    /**
     * @summary setup main class tests
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        main = new Main();
    }

    /**
     * @summary Tests hello
     */
    @Test
    public void hello() {
        String[] test = {"hello"};
        main.main(test);
        assertEquals("hello", main.hello());
    }
}