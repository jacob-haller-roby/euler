package com.project.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayNumberTest {

    @Test
    void add() {
        ArrayNumber a = new ArrayNumber();
        ArrayNumber b = new ArrayNumber();
        a.setToInt(12345);
        b.setToInt(24);
        a.add(b);

        assertEquals( "12369", a.print());
    }


    @Test
    void subtract() {
        ArrayNumber a = new ArrayNumber();
        ArrayNumber b = new ArrayNumber();
        a.setToInt(12345);
        b.setToInt(24);
        a.subtract(b);

        assertEquals( "12321", a.print());
    }

    @Test
    void subtractCarryover() {
        ArrayNumber a = new ArrayNumber();
        ArrayNumber b = new ArrayNumber();
        a.setToInt(12345);
        b.setToInt(46);
        a.subtract(b);

        assertEquals("12299", a.print());
    }

    @Test
    void subtractNegative() {
        ArrayNumber a = new ArrayNumber();
        ArrayNumber b = new ArrayNumber();
        a.setToInt(65);
        b.setToInt(12345);
        a.subtract(b);

        assertEquals("-12280", a.print());
    }

    @Test
    void multiplyNegative() {

        ArrayNumber a = new ArrayNumber();
        ArrayNumber b = new ArrayNumber();
        a.setToInt(65);
        b.setToInt(-1);
        a.multiply(b);

        assertEquals("-65", a.print());
    }

    @Test
    void pentagonal() {
        ArrayNumber a = new ArrayNumber();
        a.setToInt(870);
        a.multiply(3);
        assertEquals("2610", a.print());
        a.reduce();
        assertEquals("2609", a.print());
        a.multiply(870);
        assertEquals("2269830", a.print());
        a.divide(2);
        assertEquals("1134915", a.print());
    }
}