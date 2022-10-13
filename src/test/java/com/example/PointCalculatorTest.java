package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PointCalculatorTest {

    PointCalculator calculator = new PointCalculator();

    @Nested
    @DisplayName("ポイント無し")
    public class Point_0 {
        @Test
        @DisplayName("買物金額1円ではポイント無し")
        public void test01() {
            int actual = calculator.calculate("1");
            assertEquals(0, actual);
        }

        @Test
        @DisplayName("買物金額999円ではポイント無し")
        public void test02() {
            int actual = calculator.calculate("999");
            assertEquals(0, actual);
        }
    }

    @Nested
    @DisplayName("ポイント3%")
    public class Point_3 {
        @Test
        @DisplayName("買物金額1000円では30ポイント")
        public void test01() {
            int actual = calculator.calculate("1000");
            assertEquals(30, actual);
        }

        @Test
        @DisplayName("買物金額9999円では299ポイント")
        public void test02() {
            int actual = calculator.calculate("9999");
            assertEquals(299, actual);
        }
    }

    @Nested
    @DisplayName("ポイント5%")
    public class Point_5 {
        @Test
        @DisplayName("買物金額10000円では500ポイント")
        public void test01() {
            int actual = calculator.calculate("10000");
            assertEquals(500, actual);
        }

        @Test
        @DisplayName("買物金額9999999円では499999ポイント")
        public void test02() {
            int actual = calculator.calculate("9999999");
            assertEquals(499999, actual);
        }
    }

    @Nested
    @DisplayName("エラー")
    public class Error {
        @Test
        @DisplayName("買物金額0円ではRuntimeException")
        public void test01() {
            assertThrows(RuntimeException.class, () -> {
                calculator.calculate("0");
            });
        }

        @Test
        @DisplayName("買物金額-999999円ではRuntimeException")
        public void test02() {
            assertThrows(RuntimeException.class, () -> {
                calculator.calculate("-999999");
            });
        }

        @Test
        @DisplayName("買物金額「あああ」ではRuntimeException")
        public void test03() {
            assertThrows(RuntimeException.class, () -> {
                calculator.calculate("あああ");
            });
        }
    }
}
