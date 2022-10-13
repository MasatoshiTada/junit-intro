package com.example;

public class AgeChecker {

    public String check(int age) {
        if (age > 18) {
            return "大人";
        } else {
            return "子供";
        }
    }
}
