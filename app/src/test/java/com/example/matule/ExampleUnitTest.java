package com.example.matule;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsFalse() {
        assertFalse(MainActivity.isEmailValid(""));
    }
    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(MainActivity.isEmailValid("drnaleks@gmail.com"));
    }
}