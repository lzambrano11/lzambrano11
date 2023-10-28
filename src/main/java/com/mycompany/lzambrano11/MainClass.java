package com.mycompany.simplified_math_game;

public class MainClass {
    public static void main(String[] args) {
        QuestionGenerator qg = new QuestionGenerator();
        UserInterface ui = new UserInterface();

        int correctAnswers = 0;
        int totalQuestions = 0;

        while (correctAnswers < 10) {
            int[] operands = qg.generateOperands();
            String question = qg.generateQuestion(operands[0], operands[1]);

            ui.showQuestion(question);
            int userAnswer = ui.getUserAnswer();

            if (userAnswer == operands[0] + operands[1]) {
                correctAnswers++;
            }
            
            totalQuestions++;
        }

        System.out.println("Has respondido correctamente a " + correctAnswers + " de " + totalQuestions + " preguntas.");
    }
}
