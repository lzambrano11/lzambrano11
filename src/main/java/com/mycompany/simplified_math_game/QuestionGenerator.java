package com.mycompany.simplified_math_game;
import java.util.Random;

public class QuestionGenerator {

    private Random random;

    public QuestionGenerator() {
        this.random = new Random();
    }

    public int[] generateOperands() {
        int operand1 = random.nextInt(10) + 1;
        int operand2 = random.nextInt(10) + 1;
        return new int[]{operand1, operand2};
    }

    public String generateQuestion(int operand1, int operand2, int operationType) {
        String question = "";
        switch(operationType) {
            case 1:
                question = "¿Cuánto es " + operand1 + " + " + operand2 + "?";
                break;
            // Aquí puedes agregar más tipos de operaciones si quieres
            default:
                question = "Operación no válida";
                break;
        }
        return question;
    }

    public int calculateAnswer(int operand1, int operand2, int operationType) {
        int answer = 0;
        switch(operationType) {
            case 1:
                answer = operand1 + operand2;
                break;
            // Aquí puedes agregar más tipos de operaciones si quieres
            default:
                System.out.println("Operación no válida");
                break;
        }
        return answer;
    }
}

