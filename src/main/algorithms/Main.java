package main.algorithms;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

    public static void main(String ... args) {

        BigDecimal number = new BigDecimal(0.425);
        System.out.println(number);
        System.out.println(number.setScale(2, RoundingMode.HALF_UP));
    }
}
