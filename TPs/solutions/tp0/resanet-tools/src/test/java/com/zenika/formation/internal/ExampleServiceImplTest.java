package com.zenika.formation.internal;

import java.util.Arrays;
import org.junit.Assert;
import junit.framework.TestCase;
import com.zenika.formation.ExampleService;

public class ExampleServiceImplTest extends TestCase {

    public void testExampleServiceScramble() {
        ExampleService anExampleService = new ExampleServiceImpl();

        String in = "This is a test of the text scrambling service";
        String out = anExampleService.scramble(in);

        char[] inChars = in.toCharArray();
        char[] outChars = out.toCharArray();

        Arrays.sort(inChars);
        Arrays.sort(outChars);

        Assert.assertEquals("Uses same letters", new String(inChars), new String(outChars));
    }
}
