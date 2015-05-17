package com.zenika.formation.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.zenika.formation.ExampleService;

/**
 * Internal implementation of our example OSGi service
 */
public final class ExampleServiceImpl
    implements ExampleService {
    // implementation methods go here...

    public String scramble(String text) {
        List<Character> charList = new ArrayList<Character>();

        char[] textChars = text.toCharArray();
        for (char textChar : textChars) {
            charList.add(textChar);
        }

        Collections.shuffle(charList);

        char[] mixedChars = new char[text.length()];
        for (int i = 0; i < mixedChars.length; i++) {
            mixedChars[i] = charList.get(i);
        }

        return new String(mixedChars);
    }
}


