package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AgeCheckerTest {

    AgeChecker checker = new AgeChecker();

    @Test
    @DisplayName("年齢が20ならば大人")
    public void test01() {
        String actual = checker.check(20);
        assertEquals("大人", actual);
    }

    @Test
    @DisplayName("年齢が15ならば子供")
    public void test02() {
        String actual = checker.check(15);
        assertEquals("子供", actual);
    }
}
