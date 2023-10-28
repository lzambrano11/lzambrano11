package com.mycompany.simplified_math_game;

import java.util.Random;

public class MathGame {
    private Random random = new Random();

    public int[] generateOperands() {
        int operand1 = random.nextInt(10) + 1;
        int operand2 = random.nextInt(10) + 1;
        return new int[]{operand1, operand2};
    }

    public String generateQuestion(int operand1, int operand2) {
        return "¿Cuánto es " + operand1 + " + " + operand2 + "?";
    }
}


