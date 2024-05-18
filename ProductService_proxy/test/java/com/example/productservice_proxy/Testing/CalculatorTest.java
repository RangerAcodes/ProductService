package com.example.productservice_proxy.Testing;

import com.example.productservice_proxy.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorTest {

    @Test
    void add() {
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 2);
        assertEquals(3, result);
    }

    @Test
    void add2() {
        Calculator calculator = new Calculator();
        float result = calculator.add(-2, -2);
        assertEquals(-4, result);
    }
}